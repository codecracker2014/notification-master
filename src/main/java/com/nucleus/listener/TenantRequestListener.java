package com.nucleus.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpRequest;

import com.nucleus.multitenancy.TenantService;
import com.nucleus.persistence.SpringUtils;

public class TenantRequestListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("Got request");
		final HttpRequest request=(HttpRequest)sre.getServletRequest();
		String path="tenant1";
		final ApplicationContext applicationContext=SpringUtils.getSpringContext();
		TenantService tenantService=null;
		if(applicationContext==null)
		{
			System.out.println("context is null");
			throw new IllegalStateException();
		}
		tenantService=applicationContext.getBean(TenantService.class);
		if(tenantService==null)
		{
			System.out.println("tsc is null");
			throw new IllegalStateException();
		}
		tenantService.setTenantSchemaName(path);
	}

}
