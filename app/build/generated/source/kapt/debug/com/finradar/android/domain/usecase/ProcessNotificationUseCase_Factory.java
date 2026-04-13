package com.finradar.android.domain.usecase;

import com.finradar.android.data.parser.NotificationParser;
import com.finradar.android.domain.repository.AlertRepository;
import com.finradar.android.domain.repository.PendingSubscriptionRepository;
import com.finradar.android.domain.repository.SubscriptionRepository;
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
public final class ProcessNotificationUseCase_Factory implements Factory<ProcessNotificationUseCase> {
  private final Provider<NotificationParser> notificationParserProvider;

  private final Provider<TransactionRepository> transactionRepositoryProvider;

  private final Provider<SubscriptionRepository> subscriptionRepositoryProvider;

  private final Provider<PendingSubscriptionRepository> pendingSubscriptionRepositoryProvider;

  private final Provider<AlertRepository> alertRepositoryProvider;

  private final Provider<SubscriptionDetector> subscriptionDetectorProvider;

  private final Provider<PriceHikeDetector> priceHikeDetectorProvider;

  public ProcessNotificationUseCase_Factory(Provider<NotificationParser> notificationParserProvider,
      Provider<TransactionRepository> transactionRepositoryProvider,
      Provider<SubscriptionRepository> subscriptionRepositoryProvider,
      Provider<PendingSubscriptionRepository> pendingSubscriptionRepositoryProvider,
      Provider<AlertRepository> alertRepositoryProvider,
      Provider<SubscriptionDetector> subscriptionDetectorProvider,
      Provider<PriceHikeDetector> priceHikeDetectorProvider) {
    this.notificationParserProvider = notificationParserProvider;
    this.transactionRepositoryProvider = transactionRepositoryProvider;
    this.subscriptionRepositoryProvider = subscriptionRepositoryProvider;
    this.pendingSubscriptionRepositoryProvider = pendingSubscriptionRepositoryProvider;
    this.alertRepositoryProvider = alertRepositoryProvider;
    this.subscriptionDetectorProvider = subscriptionDetectorProvider;
    this.priceHikeDetectorProvider = priceHikeDetectorProvider;
  }

  @Override
  public ProcessNotificationUseCase get() {
    return newInstance(notificationParserProvider.get(), transactionRepositoryProvider.get(), subscriptionRepositoryProvider.get(), pendingSubscriptionRepositoryProvider.get(), alertRepositoryProvider.get(), subscriptionDetectorProvider.get(), priceHikeDetectorProvider.get());
  }

  public static ProcessNotificationUseCase_Factory create(
      Provider<NotificationParser> notificationParserProvider,
      Provider<TransactionRepository> transactionRepositoryProvider,
      Provider<SubscriptionRepository> subscriptionRepositoryProvider,
      Provider<PendingSubscriptionRepository> pendingSubscriptionRepositoryProvider,
      Provider<AlertRepository> alertRepositoryProvider,
      Provider<SubscriptionDetector> subscriptionDetectorProvider,
      Provider<PriceHikeDetector> priceHikeDetectorProvider) {
    return new ProcessNotificationUseCase_Factory(notificationParserProvider, transactionRepositoryProvider, subscriptionRepositoryProvider, pendingSubscriptionRepositoryProvider, alertRepositoryProvider, subscriptionDetectorProvider, priceHikeDetectorProvider);
  }

  public static ProcessNotificationUseCase newInstance(NotificationParser notificationParser,
      TransactionRepository transactionRepository, SubscriptionRepository subscriptionRepository,
      PendingSubscriptionRepository pendingSubscriptionRepository, AlertRepository alertRepository,
      SubscriptionDetector subscriptionDetector, PriceHikeDetector priceHikeDetector) {
    return new ProcessNotificationUseCase(notificationParser, transactionRepository, subscriptionRepository, pendingSubscriptionRepository, alertRepository, subscriptionDetector, priceHikeDetector);
  }
}
