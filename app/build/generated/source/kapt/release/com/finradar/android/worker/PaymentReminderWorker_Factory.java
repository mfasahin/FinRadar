package com.finradar.android.worker;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.finradar.android.data.preferences.UserPreferencesRepository;
import com.finradar.android.domain.repository.AlertRepository;
import com.finradar.android.domain.repository.SubscriptionRepository;
import dagger.internal.DaggerGenerated;
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
public final class PaymentReminderWorker_Factory {
  private final Provider<SubscriptionRepository> subscriptionRepositoryProvider;

  private final Provider<UserPreferencesRepository> prefsRepositoryProvider;

  private final Provider<AlertRepository> alertRepositoryProvider;

  public PaymentReminderWorker_Factory(
      Provider<SubscriptionRepository> subscriptionRepositoryProvider,
      Provider<UserPreferencesRepository> prefsRepositoryProvider,
      Provider<AlertRepository> alertRepositoryProvider) {
    this.subscriptionRepositoryProvider = subscriptionRepositoryProvider;
    this.prefsRepositoryProvider = prefsRepositoryProvider;
    this.alertRepositoryProvider = alertRepositoryProvider;
  }

  public PaymentReminderWorker get(Context context, WorkerParameters workerParams) {
    return newInstance(context, workerParams, subscriptionRepositoryProvider.get(), prefsRepositoryProvider.get(), alertRepositoryProvider.get());
  }

  public static PaymentReminderWorker_Factory create(
      Provider<SubscriptionRepository> subscriptionRepositoryProvider,
      Provider<UserPreferencesRepository> prefsRepositoryProvider,
      Provider<AlertRepository> alertRepositoryProvider) {
    return new PaymentReminderWorker_Factory(subscriptionRepositoryProvider, prefsRepositoryProvider, alertRepositoryProvider);
  }

  public static PaymentReminderWorker newInstance(Context context, WorkerParameters workerParams,
      SubscriptionRepository subscriptionRepository, UserPreferencesRepository prefsRepository,
      AlertRepository alertRepository) {
    return new PaymentReminderWorker(context, workerParams, subscriptionRepository, prefsRepository, alertRepository);
  }
}
