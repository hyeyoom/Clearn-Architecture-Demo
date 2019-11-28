package com.github.hyeyoom.dataprovider.jpa.repository;

import com.github.hyeyoom.dataprovider.jpa.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface H2DBTodoRepository extends JpaRepository<TodoEntity, String> {
}
