package com.finradar.android.presentation.settings;

import com.finradar.android.data.preferences.UserPreferencesRepository;
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

  public SettingsViewModel_Factory(Provider<UserPreferencesRepository> prefsRepoProvider) {
    this.prefsRepoProvider = prefsRepoProvider;
  }

  @Override
  public SettingsViewModel get() {
    return newInstance(prefsRepoProvider.get());
  }

  public static SettingsViewModel_Factory create(
      Provider<UserPreferencesRepository> prefsRepoProvider) {
    return new SettingsViewModel_Factory(prefsRepoProvider);
  }

  public static SettingsViewModel newInstance(UserPreferencesRepository prefsRepo) {
    return new SettingsViewModel(prefsRepo);
  }
}
