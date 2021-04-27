package com.no3003.fatlonely.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author: lz
 * @Date: 2021/4/27 17:21
 */
@Configuration
public class DbConfig {

    @Bean
    @ConfigurationProperties(prefix = "db")
    public DataSource getDataSource(){
        return new DruidDataSource();
    }
}
