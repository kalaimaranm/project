package com.kalai.lc.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;		
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class ApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println(">> inside onStartUp() ");

		// step : 1
		XmlWebApplicationContext context = new XmlWebApplicationContext();
		context.setConfigLocation("/WEB-INF/application-config.xml");
		// step : 2
		DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
		// step : 3
		System.out.println("dispatcher servlet object created successfully....");
		ServletRegistration.Dynamic sd = servletContext.addServlet("myDispatcherServlet", dispatcherServlet);
		// step : 4
		sd.setLoadOnStartup(1);
		// step : 5
		sd.addMapping("/myapp/");
	}

}

