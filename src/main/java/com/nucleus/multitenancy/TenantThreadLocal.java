package com.nucleus.multitenancy;

public class TenantThreadLocal {

	public static final ThreadLocal<String> tenantThreadLocal=new ThreadLocal<String>();
}
