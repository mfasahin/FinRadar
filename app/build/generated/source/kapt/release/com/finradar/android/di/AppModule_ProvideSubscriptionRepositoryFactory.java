package com.finradar.android.di;

import com.finradar.android.data.local.dao.SubscriptionDao;
import com.finradar.android.domain.repository.SubscriptionRepository;
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
public final class AppModule_ProvideSubscriptionRepositoryFactory implements Factory<SubscriptionRepository> {
  private final Provider<SubscriptionDao> daoProvider;

  public AppModule_ProvideSubscriptionRepositoryFactory(Provider<SubscriptionDao> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public SubscriptionRepository get() {
    return provideSubscriptionRepository(daoProvider.get());
  }

  public static AppModule_ProvideSubscriptionRepositoryFactory create(
      Provider<SubscriptionDao> daoProvider) {
    return new AppModule_ProvideSubscriptionRepositoryFactory(daoProvider);
  }

  public static SubscriptionRepository provideSubscriptionRepository(SubscriptionDao dao) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideSubscriptionRepository(dao));
  }
}
