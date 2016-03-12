package com.nucleus.multitenancy;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;

import com.nucleus.persistence.MultiTenancyUtils;
import com.nucleus.persistence.SpringUtils;

public class SchemaResolver {

	protected String resolveTenant() 
	{
		System.out.println("Inside schema resolver");
		String tenant=TenantThreadLocal.tenantThreadLocal.get();
		if(tenant!=null)
			return tenant;
		final ApplicationContext applicationContext=SpringUtils.getSpringContext();
		String tenantSchema=null;
		TenantService tenantService=null;
		MultiTenancyUtils multiTenancyUtils=null;
		if(applicationContext==null)
		{
			System.out.println("Context NUll");
			throw new IllegalStateException("Context Null");
		}
		tenantService=applicationContext.getBean(TenantServiceImpl.class);
		multiTenancyUtils=applicationContext.getBean(MultiTenancyUtils.class);
		try{
			tenantService.getTenantSchemaName();
		}catch(final BeanCreationException e)
		{
			tenantSchema=multiTenancyUtils.getDefaultSchema();
			System.out.println("Applicatino Startup, Request not initialised yet. Default schema is used {}");
			return tenantSchema;
		}
		tenantSchema=tenantService.getTenantSchemaName();
		return tenantSchema;
	}

}
