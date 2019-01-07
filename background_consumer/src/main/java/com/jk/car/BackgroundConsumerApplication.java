package com.jk.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring-dubbo-consumer.xml")
public class BackgroundConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackgroundConsumerApplication.class, args);
    }

}

