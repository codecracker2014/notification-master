package com.example.multitenanty;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

public class MyCurrentTenantIdentifierResolver implements CurrentTenantIdentifierResolver{

	 public static ThreadLocal<String> _tenantIdentifier = new ThreadLocal<String>();
	 public static String DEFAULT_TENANT_ID = "appDb";
	@Override
	public String resolveCurrentTenantIdentifier() {
		// TODO Auto-generated method stub
		System.out.println("getting tenantId");
		String tenantId=_tenantIdentifier.get();
		if(tenantId==null)
		{
			System.out.println("tenant id not set resolve to default");
			tenantId=DEFAULT_TENANT_ID;
			
		}
		return tenantId;
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		// TODO Auto-generated method stub
		return true;
	}

}
