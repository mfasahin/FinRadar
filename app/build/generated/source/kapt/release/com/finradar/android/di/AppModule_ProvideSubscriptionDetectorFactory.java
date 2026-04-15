package com.finradar.android.di;

import com.finradar.android.domain.repository.TransactionRepository;
import com.finradar.android.domain.usecase.SubscriptionDetector;
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
public final class AppModule_ProvideSubscriptionDetectorFactory implements Factory<SubscriptionDetector> {
  private final Provider<TransactionRepository> repoProvider;

  public AppModule_ProvideSubscriptionDetectorFactory(
      Provider<TransactionRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public SubscriptionDetector get() {
    return provideSubscriptionDetector(repoProvider.get());
  }

  public static AppModule_ProvideSubscriptionDetectorFactory create(
      Provider<TransactionRepository> repoProvider) {
    return new AppModule_ProvideSubscriptionDetectorFactory(repoProvider);
  }

  public static SubscriptionDetector provideSubscriptionDetector(TransactionRepository repo) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideSubscriptionDetector(repo));
  }
}
