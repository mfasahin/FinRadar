package com.finradar.android.service;

import com.finradar.android.domain.usecase.ProcessNotificationUseCase;
import dagger.Lazy;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
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
public final class NotificationListenerService_MembersInjector implements MembersInjector<NotificationListenerService> {
  private final Provider<ProcessNotificationUseCase> processNotificationUseCaseProvider;

  public NotificationListenerService_MembersInjector(
      Provider<ProcessNotificationUseCase> processNotificationUseCaseProvider) {
    this.processNotificationUseCaseProvider = processNotificationUseCaseProvider;
  }

  public static MembersInjector<NotificationListenerService> create(
      Provider<ProcessNotificationUseCase> processNotificationUseCaseProvider) {
    return new NotificationListenerService_MembersInjector(processNotificationUseCaseProvider);
  }

  @Override
  public void injectMembers(NotificationListenerService instance) {
    injectProcessNotificationUseCase(instance, DoubleCheck.lazy(processNotificationUseCaseProvider));
  }

  @InjectedFieldSignature("com.finradar.android.service.NotificationListenerService.processNotificationUseCase")
  public static void injectProcessNotificationUseCase(NotificationListenerService instance,
      Lazy<ProcessNotificationUseCase> processNotificationUseCase) {
    instance.processNotificationUseCase = processNotificationUseCase;
  }
}
