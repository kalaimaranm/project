package com.kalai.lc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class LCApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// write the bean.xml(class)(Coonfiguration class)
		System.out.println("inside configuration class bean xml");
		Class[] bean = { LCApplicationBean.class };
		return bean;
	}

	@Override
	protected String[] getServletMappings() {
		// write the mapping for DispatcherServlet - DS is created by AACDSI
		System.out.println("inside dispatcher servlet mapping");
		String[] mapping = { "/main/*" };
		return mapping;
	}

}
