package com.finradar.android.domain.usecase;

import com.finradar.android.domain.repository.TransactionRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class SubscriptionDetector_Factory implements Factory<SubscriptionDetector> {
  private final Provider<TransactionRepository> transactionRepositoryProvider;

  public SubscriptionDetector_Factory(
      Provider<TransactionRepository> transactionRepositoryProvider) {
    this.transactionRepositoryProvider = transactionRepositoryProvider;
  }

  @Override
  public SubscriptionDetector get() {
    return newInstance(transactionRepositoryProvider.get());
  }

  public static SubscriptionDetector_Factory create(
      Provider<TransactionRepository> transactionRepositoryProvider) {
    return new SubscriptionDetector_Factory(transactionRepositoryProvider);
  }

  public static SubscriptionDetector newInstance(TransactionRepository transactionRepository) {
    return new SubscriptionDetector(transactionRepository);
  }
}
