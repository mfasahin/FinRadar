package com.finradar.android.di;

import android.content.Context;
import androidx.room.Room;
import com.finradar.android.data.local.AppDatabase;
import com.finradar.android.data.local.dao.AlertDao;
import com.finradar.android.data.local.dao.SubscriptionDao;
import com.finradar.android.data.local.dao.TransactionDao;
import com.finradar.android.data.parser.SmsParser;
import com.finradar.android.data.repository.AlertRepositoryImpl;
import com.finradar.android.data.repository.SubscriptionRepositoryImpl;
import com.finradar.android.data.repository.TransactionRepositoryImpl;
import com.finradar.android.domain.repository.AlertRepository;
import com.finradar.android.domain.repository.SubscriptionRepository;
import com.finradar.android.domain.repository.TransactionRepository;
import com.finradar.android.domain.usecase.PriceHikeDetector;
import com.finradar.android.domain.usecase.SubscriptionDetector;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0012\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u0012H\u0007J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u001aH\u0007\u00a8\u0006\u001c"}, d2 = {"Lcom/finradar/android/di/AppModule;", "", "()V", "provideAlertDao", "Lcom/finradar/android/data/local/dao/AlertDao;", "db", "Lcom/finradar/android/data/local/AppDatabase;", "provideAlertRepository", "Lcom/finradar/android/domain/repository/AlertRepository;", "dao", "provideAppDatabase", "context", "Landroid/content/Context;", "providePriceHikeDetector", "Lcom/finradar/android/domain/usecase/PriceHikeDetector;", "provideSmsParser", "Lcom/finradar/android/data/parser/SmsParser;", "provideSubscriptionDao", "Lcom/finradar/android/data/local/dao/SubscriptionDao;", "provideSubscriptionDetector", "Lcom/finradar/android/domain/usecase/SubscriptionDetector;", "repo", "Lcom/finradar/android/domain/repository/TransactionRepository;", "provideSubscriptionRepository", "Lcom/finradar/android/domain/repository/SubscriptionRepository;", "provideTransactionDao", "Lcom/finradar/android/data/local/dao/TransactionDao;", "provideTransactionRepository", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.finradar.android.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.finradar.android.data.local.AppDatabase provideAppDatabase(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.finradar.android.data.local.dao.TransactionDao provideTransactionDao(@org.jetbrains.annotations.NotNull()
    com.finradar.android.data.local.AppDatabase db) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.finradar.android.data.local.dao.SubscriptionDao provideSubscriptionDao(@org.jetbrains.annotations.NotNull()
    com.finradar.android.data.local.AppDatabase db) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.finradar.android.data.local.dao.AlertDao provideAlertDao(@org.jetbrains.annotations.NotNull()
    com.finradar.android.data.local.AppDatabase db) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.finradar.android.domain.repository.TransactionRepository provideTransactionRepository(@org.jetbrains.annotations.NotNull()
    com.finradar.android.data.local.dao.TransactionDao dao) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.finradar.android.domain.repository.SubscriptionRepository provideSubscriptionRepository(@org.jetbrains.annotations.NotNull()
    com.finradar.android.data.local.dao.SubscriptionDao dao) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.finradar.android.domain.repository.AlertRepository provideAlertRepository(@org.jetbrains.annotations.NotNull()
    com.finradar.android.data.local.dao.AlertDao dao) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.finradar.android.data.parser.SmsParser provideSmsParser() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.finradar.android.domain.usecase.SubscriptionDetector provideSubscriptionDetector(@org.jetbrains.annotations.NotNull()
    com.finradar.android.domain.repository.TransactionRepository repo) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.finradar.android.domain.usecase.PriceHikeDetector providePriceHikeDetector() {
        return null;
    }
}