package com.jk.car;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan("com.jk.car.mapper")  //扫描持久层
@ImportResource("classpath:spring-dubbo-provider.xml")  //加载spring-dubbo-provider.xml文件
public class BackgroundProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackgroundProviderApplication.class, args);
    }

}

