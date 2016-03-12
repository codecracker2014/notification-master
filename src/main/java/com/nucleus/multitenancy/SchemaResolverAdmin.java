package com.nucleus.multitenancy;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

public class SchemaResolverAdmin extends SchemaResolver implements CurrentTenantIdentifierResolver{

	@Override
	public String resolveCurrentTenantIdentifier() {
		// TODO Auto-generated method stub
		String tenantResolved=resolveTenant();
		System.out.println("Resolved "+tenantResolved);
		return tenantResolved;
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		// TODO Auto-generated method stub
		return false;
	}

}
