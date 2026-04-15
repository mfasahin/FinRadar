package com.finradar.android;

import androidx.hilt.work.HiltWorkerFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class FinRadarApp_MembersInjector implements MembersInjector<FinRadarApp> {
  private final Provider<HiltWorkerFactory> workerFactoryProvider;

  public FinRadarApp_MembersInjector(Provider<HiltWorkerFactory> workerFactoryProvider) {
    this.workerFactoryProvider = workerFactoryProvider;
  }

  public static MembersInjector<FinRadarApp> create(
      Provider<HiltWorkerFactory> workerFactoryProvider) {
    return new FinRadarApp_MembersInjector(workerFactoryProvider);
  }

  @Override
  public void injectMembers(FinRadarApp instance) {
    injectWorkerFactory(instance, workerFactoryProvider.get());
  }

  @InjectedFieldSignature("com.finradar.android.FinRadarApp.workerFactory")
  public static void injectWorkerFactory(FinRadarApp instance, HiltWorkerFactory workerFactory) {
    instance.workerFactory = workerFactory;
  }
}
