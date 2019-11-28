package com.github.hyeyoom.usecase.core;

public interface UseCase<IN, OUT> {
    OUT execute(IN request);
}
