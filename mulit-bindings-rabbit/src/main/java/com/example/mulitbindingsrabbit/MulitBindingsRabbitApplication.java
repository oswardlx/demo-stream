package com.example.mulitbindingsrabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Supplier;

@SpringBootApplication
public class MulitBindingsRabbitApplication {

    public static void main(String[] args) {
        SpringApplication.run(MulitBindingsRabbitApplication.class, args);
    }

    private final AtomicBoolean semaphore = new AtomicBoolean(true);

    @Bean
    public Supplier<String> sendTestData() {
        return () -> this.semaphore.getAndSet(!this.semaphore.get()) ? "foo" : "bar";
    }

    @Bean
    public Consumer<String> receive() {
        return System.out::println;
    }
}
