package com.github.hyeyoom.usecase.core;

import java.util.concurrent.CompletionStage;
import java.util.function.Function;

public interface UseCaseExecutor<ReqDto, ResDto, Req, Res> {

    CompletionStage<ResDto> invoke(
            UseCase<Req, Res> useCase,
            ReqDto requestDto,
            Function<ReqDto, Req> requestConverter,
            Function<ResDto, Res> responseConverter
    );
}
