package com.finradar.android.presentation.dashboard;

import com.finradar.android.domain.repository.AlertRepository;
import com.finradar.android.domain.repository.SubscriptionRepository;
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
public final class DashboardViewModel_Factory implements Factory<DashboardViewModel> {
  private final Provider<SubscriptionRepository> subscriptionRepositoryProvider;

  private final Provider<AlertRepository> alertRepositoryProvider;

  public DashboardViewModel_Factory(Provider<SubscriptionRepository> subscriptionRepositoryProvider,
      Provider<AlertRepository> alertRepositoryProvider) {
    this.subscriptionRepositoryProvider = subscriptionRepositoryProvider;
    this.alertRepositoryProvider = alertRepositoryProvider;
  }

  @Override
  public DashboardViewModel get() {
    return newInstance(subscriptionRepositoryProvider.get(), alertRepositoryProvider.get());
  }

  public static DashboardViewModel_Factory create(
      Provider<SubscriptionRepository> subscriptionRepositoryProvider,
      Provider<AlertRepository> alertRepositoryProvider) {
    return new DashboardViewModel_Factory(subscriptionRepositoryProvider, alertRepositoryProvider);
  }

  public static DashboardViewModel newInstance(SubscriptionRepository subscriptionRepository,
      AlertRepository alertRepository) {
    return new DashboardViewModel(subscriptionRepository, alertRepository);
  }
}
