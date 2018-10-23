package com.test;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import com.test.config.AppConfig;
import com.test.config.WebConfig;
import com.test.config.WebSecurityConfig;

public class WebApp00Initializer extends AbstractDispatcherServletInitializer{
//public class WebApp00Initializer extends AbstractAnnotationConfigDispatcherServletInitializer	{
//
//	@Override
//	protected Class<?>[] getRootConfigClasses() {
//		// TODO Auto-generated method stub
//		return new Class<?>[] {WebSecurityConfig.class, AppConfig.class};
//	}
//
//	@Override
//	protected Class<?>[] getServletConfigClasses() {
//		// TODO Auto-generated method stub
//		return new Class<?>[] {WebConfig.class};
//	}
//
//	@Override
//	protected String[] getServletMappings() {
//		// TODO Auto-generated method stub
//		return new String[] { "/" };
//	}
//
//	@Override
//	protected Filter[] getServletFilters() {
//		 // Used to provide the ability to enter Chinese characters inside the Owner Form
//        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
//        return new Filter[]{characterEncodingFilter};
//	}
//
//	@Override
//	protected void customizeRegistration(Dynamic registration) {
//		registration.setInitParameter("enableLoggingRequestDetails", "true");
//	}


	@Override
	protected WebApplicationContext createServletApplicationContext() {
		AnnotationConfigWebApplicationContext webAppContext = new AnnotationConfigWebApplicationContext();
        webAppContext.register(WebConfig.class);
        return webAppContext;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

	@Override
	protected WebApplicationContext createRootApplicationContext() {
		AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
        rootAppContext.register(AppConfig.class,WebSecurityConfig.class);
        return rootAppContext;
	}
	
	@Override
    protected Filter[] getServletFilters() {
        // Used to provide the ability to enter Chinese characters inside the Owner Form
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
        return new Filter[]{characterEncodingFilter};
    }

}
