package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Value("${external.resource.path.prefix}")
	String prefix;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		        .allowedOrigins("*")
		        .allowedMethods("*")
		        .allowCredentials(true);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/*").addResourceLocations(prefix + "/img/");
		registry.addResourceHandler("/img/songPic/**").addResourceLocations(prefix + "/img/songPic/");
		registry.addResourceHandler("/img/singerPic/**").addResourceLocations(prefix + "/img/singerPic/");
		registry.addResourceHandler("/img/songListPic/**").addResourceLocations(prefix + "/img/songListPic/");
		registry.addResourceHandler("/song/**").addResourceLocations(prefix + "/song/");
		registry.addResourceHandler("/avatorImages/**").addResourceLocations(prefix + "/avatorImages/");
	}
}
