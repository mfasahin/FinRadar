package com.finradar.android.di

import android.content.Context
import androidx.room.Room
import com.finradar.android.data.local.AppDatabase
import com.finradar.android.data.local.dao.AlertDao
import com.finradar.android.data.local.dao.SubscriptionDao
import com.finradar.android.data.local.dao.TransactionDao
import com.finradar.android.data.parser.SmsParser
import com.finradar.android.data.repository.AlertRepositoryImpl
import com.finradar.android.data.repository.SubscriptionRepositoryImpl
import com.finradar.android.data.repository.TransactionRepositoryImpl
import com.finradar.android.domain.repository.AlertRepository
import com.finradar.android.domain.repository.SubscriptionRepository
import com.finradar.android.domain.repository.TransactionRepository
import com.finradar.android.domain.usecase.PriceHikeDetector
import com.finradar.android.domain.usecase.SubscriptionDetector
import com.finradar.android.util.SecurityUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        SQLiteDatabase.loadLibs(context)
        val passphrase = SecurityUtils.getDatabasePassphrase(context)
        val factory = SupportFactory(SQLiteDatabase.getBytes(passphrase.toCharArray()))

        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        )
            .openHelperFactory(factory)
            .addMigrations(AppDatabase.MIGRATION_3_4)
            .build()
    }

    @Provides
    @Singleton
    fun provideTransactionDao(db: AppDatabase): TransactionDao = db.transactionDao()

    @Provides
    @Singleton
    fun provideSubscriptionDao(db: AppDatabase): SubscriptionDao = db.subscriptionDao()

    @Provides
    @Singleton
    fun provideAlertDao(db: AppDatabase): AlertDao = db.alertDao()

    @Provides
    @Singleton
    fun provideTransactionRepository(dao: TransactionDao): TransactionRepository {
        return TransactionRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun provideSubscriptionRepository(dao: SubscriptionDao): SubscriptionRepository {
        return SubscriptionRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun provideAlertRepository(dao: AlertDao): AlertRepository {
        return AlertRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun provideSmsParser(): SmsParser = SmsParser()

    @Provides
    @Singleton
    fun provideSubscriptionDetector(repo: TransactionRepository): SubscriptionDetector {
        return SubscriptionDetector(repo)
    }

    @Provides
    @Singleton
    fun providePriceHikeDetector(): PriceHikeDetector = PriceHikeDetector()
}
