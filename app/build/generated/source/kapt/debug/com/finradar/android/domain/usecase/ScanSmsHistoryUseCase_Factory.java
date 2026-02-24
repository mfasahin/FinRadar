package com.finradar.android.domain.usecase;

import android.content.Context;
import com.finradar.android.domain.repository.TransactionRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class ScanSmsHistoryUseCase_Factory implements Factory<ScanSmsHistoryUseCase> {
  private final Provider<Context> contextProvider;

  private final Provider<ProcessIncomingSmsUseCase> processIncomingSmsUseCaseProvider;

  private final Provider<TransactionRepository> transactionRepositoryProvider;

  public ScanSmsHistoryUseCase_Factory(Provider<Context> contextProvider,
      Provider<ProcessIncomingSmsUseCase> processIncomingSmsUseCaseProvider,
      Provider<TransactionRepository> transactionRepositoryProvider) {
    this.contextProvider = contextProvider;
    this.processIncomingSmsUseCaseProvider = processIncomingSmsUseCaseProvider;
    this.transactionRepositoryProvider = transactionRepositoryProvider;
  }

  @Override
  public ScanSmsHistoryUseCase get() {
    return newInstance(contextProvider.get(), processIncomingSmsUseCaseProvider.get(), transactionRepositoryProvider.get());
  }

  public static ScanSmsHistoryUseCase_Factory create(Provider<Context> contextProvider,
      Provider<ProcessIncomingSmsUseCase> processIncomingSmsUseCaseProvider,
      Provider<TransactionRepository> transactionRepositoryProvider) {
    return new ScanSmsHistoryUseCase_Factory(contextProvider, processIncomingSmsUseCaseProvider, transactionRepositoryProvider);
  }

  public static ScanSmsHistoryUseCase newInstance(Context context,
      ProcessIncomingSmsUseCase processIncomingSmsUseCase,
      TransactionRepository transactionRepository) {
    return new ScanSmsHistoryUseCase(context, processIncomingSmsUseCase, transactionRepository);
  }
}
