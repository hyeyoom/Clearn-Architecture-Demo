package com.github.hyeyoom.frontweb.config;

import com.github.hyeyoom.dataprovider.jpa.repository.H2DBTodoRepository;
import com.github.hyeyoom.dataprovider.jpa.repository.JpaTodoRepository;
import com.github.hyeyoom.frontweb.rest.impl.TodoResourceImpl;
import com.github.hyeyoom.usecase.core.UseCaseExecutor;
import com.github.hyeyoom.usecase.core.UseCaseExecutorImpl;
import com.github.hyeyoom.usecase.core.gateway.TodoRepository;
import com.github.hyeyoom.usecase.core.todo.GetTodoByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ExternalModulesConfiguration {

    private final H2DBTodoRepository h2DBTodoRepository;

    @Bean
    public UseCaseExecutorImpl getUseCaseExecutor() {
        return new UseCaseExecutorImpl();
    }

    @Bean
    public TodoRepository getTodoRepository(H2DBTodoRepository repository) {
        return new JpaTodoRepository(repository);
    }

    @Bean
    public GetTodoByIdUseCase getTodoByIdUseCase(TodoRepository repository) {
        return new GetTodoByIdUseCase(repository);
    }

    @Bean
    public TodoResourceImpl getTodoResource(
            UseCaseExecutor useCaseExecutor,
            GetTodoByIdUseCase getTodoByIdUseCase
    ) {
        return new TodoResourceImpl(useCaseExecutor, getTodoByIdUseCase);
    }
}
