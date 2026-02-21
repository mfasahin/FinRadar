package com.finradar.android.service;

import com.finradar.android.domain.usecase.ProcessIncomingSmsUseCase;
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
public final class NotificationListenerService_MembersInjector implements MembersInjector<NotificationListenerService> {
  private final Provider<ProcessIncomingSmsUseCase> processIncomingSmsUseCaseProvider;

  public NotificationListenerService_MembersInjector(
      Provider<ProcessIncomingSmsUseCase> processIncomingSmsUseCaseProvider) {
    this.processIncomingSmsUseCaseProvider = processIncomingSmsUseCaseProvider;
  }

  public static MembersInjector<NotificationListenerService> create(
      Provider<ProcessIncomingSmsUseCase> processIncomingSmsUseCaseProvider) {
    return new NotificationListenerService_MembersInjector(processIncomingSmsUseCaseProvider);
  }

  @Override
  public void injectMembers(NotificationListenerService instance) {
    injectProcessIncomingSmsUseCase(instance, processIncomingSmsUseCaseProvider.get());
  }

  @InjectedFieldSignature("com.finradar.android.service.NotificationListenerService.processIncomingSmsUseCase")
  public static void injectProcessIncomingSmsUseCase(NotificationListenerService instance,
      ProcessIncomingSmsUseCase processIncomingSmsUseCase) {
    instance.processIncomingSmsUseCase = processIncomingSmsUseCase;
  }
}
