package com.site.springMVC.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MVCConfig implements WebMvcConfigurer {
    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //все запросы к сервису по пути имг/ и что-то еще буддет перенаправлять попути
        registry.addResourceHandler("http://localhost:8080/file/img/**")
                //вот этому
                .addResourceLocations("file://" + uploadPath + "/");
    }
}
