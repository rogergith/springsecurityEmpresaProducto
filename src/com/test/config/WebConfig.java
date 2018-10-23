package com.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.test.service.interceptor.Interceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {
		"com.test.controller", 
		"com.test.security.controller",
		"com.test.service.interceptor"
})
public class WebConfig implements WebMvcConfigurer{

	@Autowired
	@Qualifier("Interceptor")
	private Interceptor interceptor;
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
		
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(interceptor);
		
	}
	
	

	
}
