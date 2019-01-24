package com.ti.crowd_manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.ti.crowd_manager.mapper")
public class CrowdManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrowdManagerApplication.class, args);
    }

}

