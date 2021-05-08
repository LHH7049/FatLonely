package com.no3003.fatlonely;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Author: lz
 * @Date: 2021/5/8 14:22
 */
public class FatlonelyInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FatlonelyApplication.class);
    }
}
