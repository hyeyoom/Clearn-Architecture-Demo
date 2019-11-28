package com.github.hyeyoom.frontweb.rest.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class TodoDto {

    private String title;

    private String content;

    private boolean isDone;

    private Timestamp createdAt;
}
