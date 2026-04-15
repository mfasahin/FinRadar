package com.finradar.android.presentation.pending;

import com.finradar.android.domain.repository.PendingSubscriptionRepository;
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
public final class PendingSubscriptionViewModel_Factory implements Factory<PendingSubscriptionViewModel> {
  private final Provider<PendingSubscriptionRepository> pendingSubscriptionRepositoryProvider;

  private final Provider<SubscriptionRepository> subscriptionRepositoryProvider;

  public PendingSubscriptionViewModel_Factory(
      Provider<PendingSubscriptionRepository> pendingSubscriptionRepositoryProvider,
      Provider<SubscriptionRepository> subscriptionRepositoryProvider) {
    this.pendingSubscriptionRepositoryProvider = pendingSubscriptionRepositoryProvider;
    this.subscriptionRepositoryProvider = subscriptionRepositoryProvider;
  }

  @Override
  public PendingSubscriptionViewModel get() {
    return newInstance(pendingSubscriptionRepositoryProvider.get(), subscriptionRepositoryProvider.get());
  }

  public static PendingSubscriptionViewModel_Factory create(
      Provider<PendingSubscriptionRepository> pendingSubscriptionRepositoryProvider,
      Provider<SubscriptionRepository> subscriptionRepositoryProvider) {
    return new PendingSubscriptionViewModel_Factory(pendingSubscriptionRepositoryProvider, subscriptionRepositoryProvider);
  }

  public static PendingSubscriptionViewModel newInstance(
      PendingSubscriptionRepository pendingSubscriptionRepository,
      SubscriptionRepository subscriptionRepository) {
    return new PendingSubscriptionViewModel(pendingSubscriptionRepository, subscriptionRepository);
  }
}
