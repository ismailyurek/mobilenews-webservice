package com.mobilenews.webservice.config;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// see, https://github.com/martypitt/swagger-springmvc/blob/master/swagger-springmvc/src/main/java/com/mangofactory/swagger/plugin/SwaggerSpringMvcPlugin.java
// see, http://stackoverflow.com/questions/27843565/how-to-configure-two-swagger-groups

@EnableWebMvc
@EnableSwagger
@ComponentScan
@Configuration
public class SwaggerConfig {

    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean
    public SwaggerSpringMvcPlugin customImplementation(){
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(apiInfo())
                .includePatterns(".*/welcome/.*", ".*/blabla/.*");
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Mobile News Service",
                "Mobile News Service",
                "Mobile News Service Terms",
                "info@mobilenews.com",
                "Mobile News Service API Licence Type",
                "/swagger/licence.html"
        );
        return apiInfo;
    }
}