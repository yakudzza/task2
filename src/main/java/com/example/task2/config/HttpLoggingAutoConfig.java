package com.example.task2.config;


import com.example.task2.filter.HttpLoggingFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Filter;

@Configuration
@ConditionalOnClass(Filter.class)
@ConditionalOnProperty(name = "http.logging.enabled", havingValue = "true", matchIfMissing = true)
public class HttpLoggingAutoConfig {

    @Bean
    public HttpLoggingFilter httpLoggingFilter() {
        return new HttpLoggingFilter();
    }
}
