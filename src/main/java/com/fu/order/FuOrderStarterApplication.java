package com.fu.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by walter on 17/7/11.
 */

@EnableAutoConfiguration
@SpringBootApplication
@MapperScan(basePackages="com.fu.order.dao.mapper")
public class FuOrderStarterApplication {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(FuOrderStarterApplication.class, args);
    }

}
