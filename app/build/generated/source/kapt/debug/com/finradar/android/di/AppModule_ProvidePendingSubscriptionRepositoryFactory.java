package com.finradar.android.di;

import android.content.Context;
import com.finradar.android.domain.repository.PendingSubscriptionRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class AppModule_ProvidePendingSubscriptionRepositoryFactory implements Factory<PendingSubscriptionRepository> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvidePendingSubscriptionRepositoryFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public PendingSubscriptionRepository get() {
    return providePendingSubscriptionRepository(contextProvider.get());
  }

  public static AppModule_ProvidePendingSubscriptionRepositoryFactory create(
      Provider<Context> contextProvider) {
    return new AppModule_ProvidePendingSubscriptionRepositoryFactory(contextProvider);
  }

  public static PendingSubscriptionRepository providePendingSubscriptionRepository(
      Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.providePendingSubscriptionRepository(context));
  }
}
