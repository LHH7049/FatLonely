package com.no3003.fatlonely;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan
public class FatlonelyApplication {

    public static void main(String[] args) {
        SpringApplication.run(FatlonelyApplication.class, args);
    }

}
