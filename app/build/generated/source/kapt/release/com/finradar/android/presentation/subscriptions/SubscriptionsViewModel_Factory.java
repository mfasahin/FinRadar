package com.finradar.android.presentation.subscriptions;

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
public final class SubscriptionsViewModel_Factory implements Factory<SubscriptionsViewModel> {
  private final Provider<SubscriptionRepository> subscriptionRepositoryProvider;

  public SubscriptionsViewModel_Factory(
      Provider<SubscriptionRepository> subscriptionRepositoryProvider) {
    this.subscriptionRepositoryProvider = subscriptionRepositoryProvider;
  }

  @Override
  public SubscriptionsViewModel get() {
    return newInstance(subscriptionRepositoryProvider.get());
  }

  public static SubscriptionsViewModel_Factory create(
      Provider<SubscriptionRepository> subscriptionRepositoryProvider) {
    return new SubscriptionsViewModel_Factory(subscriptionRepositoryProvider);
  }

  public static SubscriptionsViewModel newInstance(SubscriptionRepository subscriptionRepository) {
    return new SubscriptionsViewModel(subscriptionRepository);
  }
}
