package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowCredentials(true);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/*").addResourceLocations("file:D:/data/img/");
        registry.addResourceHandler("/img/songPic/**").addResourceLocations("file:D:/data/img/songPic/");
        registry.addResourceHandler("/img/singerPic/**").addResourceLocations("file:D:/data/img/singerPic/");
        registry.addResourceHandler("/img/songListPic/**").addResourceLocations("file:D:/data/img/songListPic/");
        registry.addResourceHandler("/song/**").addResourceLocations("file:D:/data/song/");
        registry.addResourceHandler("/avatorImages/**").addResourceLocations("file:D:/data/avatorImages/");
    }
}
