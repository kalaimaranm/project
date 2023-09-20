package com.kalai.lc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.kalai.lc.service.Category;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.kalai.lc")
public class LCApplicationBean {

	@Bean
	public Category category() {
		return new Category();
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		System.out.println(" resolver");
		return viewResolver;

	}
}
