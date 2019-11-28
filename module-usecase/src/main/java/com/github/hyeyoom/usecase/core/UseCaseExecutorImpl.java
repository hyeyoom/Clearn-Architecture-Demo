package com.github.hyeyoom.usecase.core;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;

public class UseCaseExecutorImpl implements UseCaseExecutor {

    @Override
    @SuppressWarnings("unchecked")
    public CompletionStage invoke(
            UseCase useCase,
            Object requestDto,
            Function requestConverter,
            Function responseConverter) {
        return CompletableFuture
                .supplyAsync(() -> requestConverter.apply(requestDto))
                .thenApplyAsync((Function<Object, Object>) useCase::execute)
                .thenApplyAsync((Function<Object, Object>) responseConverter);
    }
}
