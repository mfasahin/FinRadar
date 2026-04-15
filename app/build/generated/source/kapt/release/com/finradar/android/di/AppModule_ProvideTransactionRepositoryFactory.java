package com.finradar.android.di;

import com.finradar.android.data.local.dao.TransactionDao;
import com.finradar.android.domain.repository.TransactionRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AppModule_ProvideTransactionRepositoryFactory implements Factory<TransactionRepository> {
  private final Provider<TransactionDao> daoProvider;

  public AppModule_ProvideTransactionRepositoryFactory(Provider<TransactionDao> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public TransactionRepository get() {
    return provideTransactionRepository(daoProvider.get());
  }

  public static AppModule_ProvideTransactionRepositoryFactory create(
      Provider<TransactionDao> daoProvider) {
    return new AppModule_ProvideTransactionRepositoryFactory(daoProvider);
  }

  public static TransactionRepository provideTransactionRepository(TransactionDao dao) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideTransactionRepository(dao));
  }
}
