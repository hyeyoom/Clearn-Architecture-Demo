package com.github.hyeyoom.usecase.core.todo;

import com.github.hyeyoom.core.entities.Todo;
import com.github.hyeyoom.usecase.core.UseCase;
import com.github.hyeyoom.usecase.core.exception.DataSaveFailureException;
import com.github.hyeyoom.usecase.core.exception.ValidationCheckException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class CreateTodoUseCase implements UseCase<Todo, String> {

    private final TodoRepository todoRepository;

    @Override
    public String execute(Todo todo) {
        checkTodoValidation(todo);
        return todoRepository
                .save(todo)
                .orElseThrow(() -> new DataSaveFailureException("Todo was not saved!"))
                .getId();
    }

    private void checkTodoValidation(Todo todo) {
        if (null == todo.getTitle()) {
            throw new ValidationCheckException("Title cannot be empty!");
        }

        if (null == todo.getContent()) {
            throw new ValidationCheckException("Content cannot be empty!");
        }
    }

    public interface TodoRepository {
        Optional<Todo> save(Todo todo);
    }
}
