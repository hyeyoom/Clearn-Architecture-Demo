package com.github.hyeyoom.dataprovider.jpa.repository;

import com.github.hyeyoom.core.entities.Todo;
import com.github.hyeyoom.dataprovider.jpa.entity.TodoEntity;
import com.github.hyeyoom.usecase.core.gateway.TodoRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class JpaTodoRepository implements TodoRepository {

    private final H2DBTodoRepository repository;

    @Override
    public Optional<Todo> save(Todo todo) {
        final TodoEntity entity = repository.save(TodoEntity.toEntity(todo));
        return Optional.of(entity.toTodo());
    }

    @Override
    public Optional<Todo> getById(String id) {
        final TodoEntity entity = repository.findById(id).orElse(null);
        return Optional.ofNullable(entity != null ? entity.toTodo() : null);
    }
}
