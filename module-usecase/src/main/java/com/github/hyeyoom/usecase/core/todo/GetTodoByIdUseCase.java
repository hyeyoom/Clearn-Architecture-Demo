package com.github.hyeyoom.usecase.core.todo;

import com.github.hyeyoom.core.entities.Todo;
import com.github.hyeyoom.usecase.core.UseCase;
import com.github.hyeyoom.usecase.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class GetTodoByIdUseCase implements UseCase<String, Todo> {

    private final TodoRepository todoRepository;

    @Override
    public Todo execute(String id) {
        return todoRepository
                .getById(id)
                .orElseThrow(() -> new NotFoundException("There is no Todo for give id: " + id));
    }

    public interface TodoRepository {
        Optional<Todo> getById(String id);
    }

}
