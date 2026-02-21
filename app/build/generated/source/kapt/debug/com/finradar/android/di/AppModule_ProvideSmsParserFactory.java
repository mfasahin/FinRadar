package com.finradar.android.di;

import com.finradar.android.data.parser.SmsParser;
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
public final class AppModule_ProvideSmsParserFactory implements Factory<SmsParser> {
  @Override
  public SmsParser get() {
    return provideSmsParser();
  }

  public static AppModule_ProvideSmsParserFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static SmsParser provideSmsParser() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideSmsParser());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideSmsParserFactory INSTANCE = new AppModule_ProvideSmsParserFactory();
  }
}
