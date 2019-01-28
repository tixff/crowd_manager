package com.ti.crowd_manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableTransactionManagement
@MapperScan("com.ti.crowd_manager.mapper")
public class CrowdManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrowdManagerApplication.class, args);
    }

}

