package com.finradar.android.worker;

import android.content.Context;
import androidx.work.WorkerParameters;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class PaymentReminderWorker_AssistedFactory_Impl implements PaymentReminderWorker_AssistedFactory {
  private final PaymentReminderWorker_Factory delegateFactory;

  PaymentReminderWorker_AssistedFactory_Impl(PaymentReminderWorker_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public PaymentReminderWorker create(Context arg0, WorkerParameters arg1) {
    return delegateFactory.get(arg0, arg1);
  }

  public static Provider<PaymentReminderWorker_AssistedFactory> create(
      PaymentReminderWorker_Factory delegateFactory) {
    return InstanceFactory.create(new PaymentReminderWorker_AssistedFactory_Impl(delegateFactory));
  }

  public static dagger.internal.Provider<PaymentReminderWorker_AssistedFactory> createFactoryProvider(
      PaymentReminderWorker_Factory delegateFactory) {
    return InstanceFactory.create(new PaymentReminderWorker_AssistedFactory_Impl(delegateFactory));
  }
}
