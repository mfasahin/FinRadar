package com.finradar.android.domain.usecase;

import com.finradar.android.data.parser.SmsParser;
import com.finradar.android.domain.repository.AlertRepository;
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
public final class ProcessIncomingSmsUseCase_Factory implements Factory<ProcessIncomingSmsUseCase> {
  private final Provider<SmsParser> smsParserProvider;

  private final Provider<TransactionRepository> transactionRepositoryProvider;

  private final Provider<SubscriptionRepository> subscriptionRepositoryProvider;

  private final Provider<AlertRepository> alertRepositoryProvider;

  private final Provider<SubscriptionDetector> subscriptionDetectorProvider;

  private final Provider<PriceHikeDetector> priceHikeDetectorProvider;

  public ProcessIncomingSmsUseCase_Factory(Provider<SmsParser> smsParserProvider,
      Provider<TransactionRepository> transactionRepositoryProvider,
      Provider<SubscriptionRepository> subscriptionRepositoryProvider,
      Provider<AlertRepository> alertRepositoryProvider,
      Provider<SubscriptionDetector> subscriptionDetectorProvider,
      Provider<PriceHikeDetector> priceHikeDetectorProvider) {
    this.smsParserProvider = smsParserProvider;
    this.transactionRepositoryProvider = transactionRepositoryProvider;
    this.subscriptionRepositoryProvider = subscriptionRepositoryProvider;
    this.alertRepositoryProvider = alertRepositoryProvider;
    this.subscriptionDetectorProvider = subscriptionDetectorProvider;
    this.priceHikeDetectorProvider = priceHikeDetectorProvider;
  }

  @Override
  public ProcessIncomingSmsUseCase get() {
    return newInstance(smsParserProvider.get(), transactionRepositoryProvider.get(), subscriptionRepositoryProvider.get(), alertRepositoryProvider.get(), subscriptionDetectorProvider.get(), priceHikeDetectorProvider.get());
  }

  public static ProcessIncomingSmsUseCase_Factory create(Provider<SmsParser> smsParserProvider,
      Provider<TransactionRepository> transactionRepositoryProvider,
      Provider<SubscriptionRepository> subscriptionRepositoryProvider,
      Provider<AlertRepository> alertRepositoryProvider,
      Provider<SubscriptionDetector> subscriptionDetectorProvider,
      Provider<PriceHikeDetector> priceHikeDetectorProvider) {
    return new ProcessIncomingSmsUseCase_Factory(smsParserProvider, transactionRepositoryProvider, subscriptionRepositoryProvider, alertRepositoryProvider, subscriptionDetectorProvider, priceHikeDetectorProvider);
  }

  public static ProcessIncomingSmsUseCase newInstance(SmsParser smsParser,
      TransactionRepository transactionRepository, SubscriptionRepository subscriptionRepository,
      AlertRepository alertRepository, SubscriptionDetector subscriptionDetector,
      PriceHikeDetector priceHikeDetector) {
    return new ProcessIncomingSmsUseCase(smsParser, transactionRepository, subscriptionRepository, alertRepository, subscriptionDetector, priceHikeDetector);
  }
}
