package com.github.hyeyoom.usecase.core.gateway;

import com.github.hyeyoom.usecase.core.todo.CreateTodoUseCase;
import com.github.hyeyoom.usecase.core.todo.GetTodoByIdUseCase;

public interface TodoRepository extends
        CreateTodoUseCase.TodoRepository,
        GetTodoByIdUseCase.TodoRepository {
}
