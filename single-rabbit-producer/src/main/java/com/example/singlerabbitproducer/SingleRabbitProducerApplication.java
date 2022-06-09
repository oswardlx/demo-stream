package com.example.singlerabbitproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

@SpringBootApplication
public class SingleRabbitProducerApplication {
    private final AtomicBoolean semaphore = new AtomicBoolean(true);

    public static void main(String[] args) {
        SpringApplication.run(SingleRabbitProducerApplication.class, args);
    }

    @Bean
    public Supplier<String> sendTestData() {
        return () -> this.semaphore.getAndSet(!this.semaphore.get()) ? "foo" : "bar";
    }
}
