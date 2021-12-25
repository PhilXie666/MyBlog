package com.demo.xwx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.demo.xwx.mapper")
public class SystemEntrance {

    public static void main(String[] args) {

        SpringApplication.run(SystemEntrance.class, args);

    }

    @GetMapping("/hello")
    public String hello() {
        return "SpringBoot的Helloworld";
    }

}
