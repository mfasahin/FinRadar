package com.finradar.android.di;

import com.finradar.android.domain.usecase.PriceHikeDetector;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class AppModule_ProvidePriceHikeDetectorFactory implements Factory<PriceHikeDetector> {
  @Override
  public PriceHikeDetector get() {
    return providePriceHikeDetector();
  }

  public static AppModule_ProvidePriceHikeDetectorFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static PriceHikeDetector providePriceHikeDetector() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.providePriceHikeDetector());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvidePriceHikeDetectorFactory INSTANCE = new AppModule_ProvidePriceHikeDetectorFactory();
  }
}
