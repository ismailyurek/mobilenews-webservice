package com.mobilenews.webservice;

import com.mangofactory.swagger.plugin.EnableSwagger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import sun.rmi.runtime.Log;

import java.util.Arrays;

@EnableSwagger
@EnableWebMvc
@EnableCaching
@EnableAutoConfiguration
@ComponentScan
@Configuration
@ImportResource("classpath:spring-config.xml")
public class Application {

    static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);


        LOG.info("Let's inspect the beans provided by Spring Boot:");
        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            LOG.info(beanName);
        }
    }
}
