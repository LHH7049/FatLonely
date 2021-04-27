package com.no3003.fatlonely;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class FatlonelyApplication {

    public static void main(String[] args) {
        SpringApplication.run(FatlonelyApplication.class, args);
    }

}
