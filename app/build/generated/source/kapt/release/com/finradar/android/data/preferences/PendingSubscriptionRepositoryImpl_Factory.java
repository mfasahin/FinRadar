package com.finradar.android.data.preferences;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class PendingSubscriptionRepositoryImpl_Factory implements Factory<PendingSubscriptionRepositoryImpl> {
  private final Provider<Context> contextProvider;

  public PendingSubscriptionRepositoryImpl_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public PendingSubscriptionRepositoryImpl get() {
    return newInstance(contextProvider.get());
  }

  public static PendingSubscriptionRepositoryImpl_Factory create(
      Provider<Context> contextProvider) {
    return new PendingSubscriptionRepositoryImpl_Factory(contextProvider);
  }

  public static PendingSubscriptionRepositoryImpl newInstance(Context context) {
    return new PendingSubscriptionRepositoryImpl(context);
  }
}
