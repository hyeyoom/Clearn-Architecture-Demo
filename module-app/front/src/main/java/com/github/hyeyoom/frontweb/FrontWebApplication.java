package com.github.hyeyoom.frontweb;

import com.github.hyeyoom.dataprovider.jpa.entity.TodoEntity;
import com.github.hyeyoom.dataprovider.jpa.repository.H2DBTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;

@SpringBootApplication(
        scanBasePackages = {
                "com.github.hyeyoom.frontweb.*",
                "com.github.hyeyoom.dataprovider.jpa.config"
        }
)
public class FrontWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontWebApplication.class, args);
    }

    @Autowired
    private H2DBTodoRepository h2DBTodoRepository;

    @Bean
    public CommandLineRunner run() {
        return args -> {
            // initial test data
            TodoEntity t = new TodoEntity();
            t.setTitle("Clean Architecture!");
            t.setContent("So cool");
            t.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            t.setDone(true);
            h2DBTodoRepository.save(t);
        };
    }
}
