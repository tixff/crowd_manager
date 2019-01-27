package com.ti.crowd_manager;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Ti
 * @date 2018/12/4
 */

@Configuration
public class MyWebMvc implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**", "/static/**","/js/**","/lib/**")
                .addResourceLocations("classpath:/templates/", "classpath:/static/","classpath:/templates/js/","classpath:/templates/lib/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/templates/css/");
    }

}
