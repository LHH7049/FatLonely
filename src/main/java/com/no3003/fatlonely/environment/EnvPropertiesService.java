package com.no3003.fatlonely.environment;

import org.springframework.util.StringUtils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * @Author: lz
 * @Date: 2021/4/27 16:40
 */
public class EnvPropertiesService {
    public static final EnvPropertiesService INSTANCE = new EnvPropertiesService();

    private EnvPropertiesService(){}

    public void loadEnv() throws Exception {
        String env = System.getProperty("env");
        if (!"dev".equals(env) && !"test".equals(env) && !"production".equals(env)){
            throw new IllegalArgumentException("没有env配置");
        }
        String envPath = System.getProperty("env.path");
        if (!StringUtils.hasText(envPath)){
            URL url = this.getClass().getClassLoader().getResource(String.format("env/%s.properties", env));
            if (url == null){
                throw new IllegalArgumentException(String.format("没有%s配置", env));
            }
            envPath = url.getPath();
        }
        try (InputStream is = new FileInputStream(envPath);){
            Properties properties = new Properties();
            properties.load(is);
            System.getProperties().putAll(properties);
        }
    }
}
