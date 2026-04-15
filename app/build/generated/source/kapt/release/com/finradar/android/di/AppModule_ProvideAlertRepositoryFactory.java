package com.finradar.android.di;

import com.finradar.android.data.local.dao.AlertDao;
import com.finradar.android.domain.repository.AlertRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AppModule_ProvideAlertRepositoryFactory implements Factory<AlertRepository> {
  private final Provider<AlertDao> daoProvider;

  public AppModule_ProvideAlertRepositoryFactory(Provider<AlertDao> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public AlertRepository get() {
    return provideAlertRepository(daoProvider.get());
  }

  public static AppModule_ProvideAlertRepositoryFactory create(Provider<AlertDao> daoProvider) {
    return new AppModule_ProvideAlertRepositoryFactory(daoProvider);
  }

  public static AlertRepository provideAlertRepository(AlertDao dao) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAlertRepository(dao));
  }
}
