package com.github.hyeyoom.core.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class Todo {

    private String id;

    private String title;

    private String content;

    private boolean isDone;

    private Timestamp createdAt;
}
