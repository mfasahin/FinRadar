package com.finradar.android.presentation.subscriptions;

import com.finradar.android.domain.repository.SubscriptionRepository;
import com.finradar.android.domain.usecase.ScanSmsHistoryUseCase;
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
public final class SubscriptionsViewModel_Factory implements Factory<SubscriptionsViewModel> {
  private final Provider<SubscriptionRepository> subscriptionRepositoryProvider;

  private final Provider<ScanSmsHistoryUseCase> scanSmsHistoryUseCaseProvider;

  public SubscriptionsViewModel_Factory(
      Provider<SubscriptionRepository> subscriptionRepositoryProvider,
      Provider<ScanSmsHistoryUseCase> scanSmsHistoryUseCaseProvider) {
    this.subscriptionRepositoryProvider = subscriptionRepositoryProvider;
    this.scanSmsHistoryUseCaseProvider = scanSmsHistoryUseCaseProvider;
  }

  @Override
  public SubscriptionsViewModel get() {
    return newInstance(subscriptionRepositoryProvider.get(), scanSmsHistoryUseCaseProvider.get());
  }

  public static SubscriptionsViewModel_Factory create(
      Provider<SubscriptionRepository> subscriptionRepositoryProvider,
      Provider<ScanSmsHistoryUseCase> scanSmsHistoryUseCaseProvider) {
    return new SubscriptionsViewModel_Factory(subscriptionRepositoryProvider, scanSmsHistoryUseCaseProvider);
  }

  public static SubscriptionsViewModel newInstance(SubscriptionRepository subscriptionRepository,
      ScanSmsHistoryUseCase scanSmsHistoryUseCase) {
    return new SubscriptionsViewModel(subscriptionRepository, scanSmsHistoryUseCase);
  }
}
