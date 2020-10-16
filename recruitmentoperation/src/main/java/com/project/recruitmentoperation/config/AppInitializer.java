package com.project.recruitmentoperation.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
    protected Class < ? > [] getRootConfigClasses() {
	//	System.out.println("!!!!!!!!!!!!!!!!");

		 return new Class[] {
            AppContext.class
        };
        //return null;
    }

	@Override
    protected Class < ? > [] getServletConfigClasses() {
	//	System.out.println("@@@@@@@@@@@@@@");

        return new Class[] {
            WebMvcConfig.class
        };
    }

	@Override
	protected String[] getServletMappings() {
	//	System.out.println("$$$$$$$$$$$$$$$$");

		return new String[] { "/" };
	}

}
