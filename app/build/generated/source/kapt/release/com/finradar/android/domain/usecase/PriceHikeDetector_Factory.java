package com.finradar.android.domain.usecase;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class PriceHikeDetector_Factory implements Factory<PriceHikeDetector> {
  @Override
  public PriceHikeDetector get() {
    return newInstance();
  }

  public static PriceHikeDetector_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static PriceHikeDetector newInstance() {
    return new PriceHikeDetector();
  }

  private static final class InstanceHolder {
    private static final PriceHikeDetector_Factory INSTANCE = new PriceHikeDetector_Factory();
  }
}
