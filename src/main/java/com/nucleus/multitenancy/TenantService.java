package com.nucleus.multitenancy;

public interface TenantService {

	String getTenantSchemaName();
	void setTenantSchemaName(String schemaName);
}
