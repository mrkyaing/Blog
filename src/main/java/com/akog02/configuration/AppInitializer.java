package com.akog02.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends
          AbstractAnnotationConfigDispatcherServletInitializer {
    
    @Override
    protected Class<?>[] getRootConfigClasses () {
        return null;
    }
    
    @Override
    protected Class<?>[] getServletConfigClasses () {
        return new Class<?>[]{WebConfiguration.class};
    }
    
    @Override
    protected String[] getServletMappings () {
        return new String[]{"/"};
    }
}
