package com.finradar.android.presentation.settings;

import com.finradar.android.data.preferences.UserPreferencesRepository;
import com.finradar.android.domain.repository.PendingSubscriptionRepository;
import com.finradar.android.domain.usecase.ProcessNotificationUseCase;
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
public final class SettingsViewModel_Factory implements Factory<SettingsViewModel> {
  private final Provider<UserPreferencesRepository> prefsRepoProvider;

  private final Provider<PendingSubscriptionRepository> pendingSubscriptionRepositoryProvider;

  private final Provider<ProcessNotificationUseCase> processNotificationUseCaseProvider;

  public SettingsViewModel_Factory(Provider<UserPreferencesRepository> prefsRepoProvider,
      Provider<PendingSubscriptionRepository> pendingSubscriptionRepositoryProvider,
      Provider<ProcessNotificationUseCase> processNotificationUseCaseProvider) {
    this.prefsRepoProvider = prefsRepoProvider;
    this.pendingSubscriptionRepositoryProvider = pendingSubscriptionRepositoryProvider;
    this.processNotificationUseCaseProvider = processNotificationUseCaseProvider;
  }

  @Override
  public SettingsViewModel get() {
    return newInstance(prefsRepoProvider.get(), pendingSubscriptionRepositoryProvider.get(), processNotificationUseCaseProvider.get());
  }

  public static SettingsViewModel_Factory create(
      Provider<UserPreferencesRepository> prefsRepoProvider,
      Provider<PendingSubscriptionRepository> pendingSubscriptionRepositoryProvider,
      Provider<ProcessNotificationUseCase> processNotificationUseCaseProvider) {
    return new SettingsViewModel_Factory(prefsRepoProvider, pendingSubscriptionRepositoryProvider, processNotificationUseCaseProvider);
  }

  public static SettingsViewModel newInstance(UserPreferencesRepository prefsRepo,
      PendingSubscriptionRepository pendingSubscriptionRepository,
      ProcessNotificationUseCase processNotificationUseCase) {
    return new SettingsViewModel(prefsRepo, pendingSubscriptionRepository, processNotificationUseCase);
  }
}
