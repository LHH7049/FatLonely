package com.no3003.fatlonely.listener;

import com.no3003.fatlonely.env.EnvPropertiesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Author: lz
 * @Date: 2021/4/27 16:56
 */
@WebListener
public class AppInitListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(AppInitListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            EnvPropertiesService.INSTANCE.loadEnv();
            logger.info("======= 初始化完毕========");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
