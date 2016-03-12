package com.nucleus.persistence;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringUtils implements ApplicationContextAware{

	private static ApplicationContext applicationContext = null; 
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("Initializing");
		SpringUtils.applicationContext = applicationContext; 
		
	}
	
	public static ApplicationContext getSpringContext() {  
        return applicationContext;  
    }  

}
