package com.github.hyeyoom.dataprovider.jpa.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.github.hyeyoom.dataprovider.jpa.entity")
@EnableJpaRepositories(basePackages = "com.github.hyeyoom.dataprovider.jpa.repository")
public class DatabaseConfiguration {
}
