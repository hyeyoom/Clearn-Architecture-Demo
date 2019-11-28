package com.github.hyeyoom.dataprovider.jpa.entity;

import com.github.hyeyoom.core.entities.Todo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@Table(name = "todos")
@EqualsAndHashCode(of = "id")
public class TodoEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private boolean isDone = false;

    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    public Todo toTodo() {
        final Todo todo = new Todo();
        todo.setId(id);
        todo.setTitle(title);
        todo.setContent(content);
        todo.setDone(isDone);
        todo.setCreatedAt(createdAt);
        return todo;
    }

    public static TodoEntity toEntity(Todo todo) {
        final TodoEntity entity = new TodoEntity();
        entity.setTitle(todo.getTitle());
        entity.setContent(todo.getContent());
        entity.setDone(todo.isDone());
        entity.setCreatedAt(todo.getCreatedAt());
        return entity;
    }
}
