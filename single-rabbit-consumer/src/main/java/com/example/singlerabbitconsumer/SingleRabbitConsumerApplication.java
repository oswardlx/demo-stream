package com.example.singlerabbitconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class SingleRabbitConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SingleRabbitConsumerApplication.class, args);
    }

    @Bean
    public Consumer<String> receive() {
        return System.out::println;
    }

}
