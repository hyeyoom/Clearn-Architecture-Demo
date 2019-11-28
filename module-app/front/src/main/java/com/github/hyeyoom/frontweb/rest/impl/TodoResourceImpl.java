package com.github.hyeyoom.frontweb.rest.impl;

import com.github.hyeyoom.core.entities.Todo;
import com.github.hyeyoom.frontweb.rest.api.TodoDto;
import com.github.hyeyoom.frontweb.rest.api.TodoResource;
import com.github.hyeyoom.usecase.core.UseCaseExecutor;
import com.github.hyeyoom.usecase.core.todo.GetTodoByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.CompletionStage;

@RequiredArgsConstructor
@SuppressWarnings("unchecked")
public class TodoResourceImpl implements TodoResource {

    private final UseCaseExecutor useCaseExecutor;

    private final GetTodoByIdUseCase getTodoByIdUseCase;

    @Override
    public CompletionStage<ResponseEntity<Todo>> getTodoById(String id) {
        return useCaseExecutor.invoke(
                getTodoByIdUseCase,
                id,
                o -> id,
                o -> {
                    Todo todo = (Todo) o;
                    TodoDto td = new TodoDto();
                    td.setTitle(todo.getTitle());
                    td.setContent(todo.getContent());
                    td.setDone(todo.isDone());
                    td.setCreatedAt(todo.getCreatedAt());
                    return td;
                }
        );
    }
}

