package com.nucleus.multitenancy;

import java.util.Properties;

import javax.annotation.Resource;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value=WebApplicationContext.SCOPE_REQUEST,proxyMode=ScopedProxyMode.TARGET_CLASS)
public class TenantServiceImpl implements TenantService {

	public TenantServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Creating tenant service");
	}

	private static Logger logger=Logger.getLogger(TenantThreadLocal.class);
	private String tenantName=null;
	
	@Resource(name="multitenancyConfiguration")
	private Properties properties;
	@Override
	public String getTenantSchemaName() {
		// TODO Auto-generated method stub
		return tenantName;
	}

	@Override
	public void setTenantSchemaName(final String schemaName) {
		// TODO Auto-generated method stub
		logger.debug("Request URL path is {}"+schemaName);
		System.out.println("Request URL path is {}"+schemaName);
		if(schemaName!=null && schemaName.equals(""))
		{
			logger.error("Request URl is blank");
			throw new IllegalStateException();
		}
		String tenantKey=null;
		String tenant=null;
		if(schemaName.equals("tenant1"))
		{
			tenantKey="tenant1";
			tenant=properties.getProperty(tenantKey);
			System.out.println("Yaa "+properties.toString());
		}
		else
		{
			logger.warn("tenant not identified");
			
		}
		if(tenant==null||tenant.equals(""))
		{
			logger.error("tenent schema not found");
			throw new IllegalStateException("No tenant schema exists in property file for key with value");
		}
		MDC.put("tenant", tenantKey);
		logger.debug("Tenant for demo request is {}"+tenantKey);
		tenantName=tenant;
	}

}
