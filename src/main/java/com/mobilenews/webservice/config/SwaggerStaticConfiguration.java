package com.mobilenews.webservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SwaggerStaticConfiguration extends WebMvcConfigurerAdapter {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            //"classpath:/META-INF/resources/",
            //"classpath:/resources/",
            //"classpath:/static/",
            //"classpath:/public/",
            "classpath:/public/apidoc/"};

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
        registry.addResourceHandler("/apidoc/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }
}