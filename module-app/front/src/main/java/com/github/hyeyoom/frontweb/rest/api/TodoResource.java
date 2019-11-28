package com.github.hyeyoom.frontweb.rest.api;

import com.github.hyeyoom.core.entities.Todo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletionStage;

@RestController
@RequestMapping("/api/v1/todo")
public interface TodoResource {

    @GetMapping("/{id}")
    CompletionStage<ResponseEntity<Todo>> getTodoById(@PathVariable String id);
}
