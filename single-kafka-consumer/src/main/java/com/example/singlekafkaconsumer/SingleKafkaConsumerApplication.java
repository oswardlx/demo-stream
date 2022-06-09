package com.example.singlekafkaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class SingleKafkaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SingleKafkaConsumerApplication.class, args);
    }

    @Bean
    public Consumer<String> receive() {
        return System.out::println;
    }
}
