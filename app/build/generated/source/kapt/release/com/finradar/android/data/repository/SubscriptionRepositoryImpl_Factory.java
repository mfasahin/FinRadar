package com.finradar.android.data.repository;

import com.finradar.android.data.local.dao.SubscriptionDao;
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
public final class SubscriptionRepositoryImpl_Factory implements Factory<SubscriptionRepositoryImpl> {
  private final Provider<SubscriptionDao> daoProvider;

  public SubscriptionRepositoryImpl_Factory(Provider<SubscriptionDao> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public SubscriptionRepositoryImpl get() {
    return newInstance(daoProvider.get());
  }

  public static SubscriptionRepositoryImpl_Factory create(Provider<SubscriptionDao> daoProvider) {
    return new SubscriptionRepositoryImpl_Factory(daoProvider);
  }

  public static SubscriptionRepositoryImpl newInstance(SubscriptionDao dao) {
    return new SubscriptionRepositoryImpl(dao);
  }
}
