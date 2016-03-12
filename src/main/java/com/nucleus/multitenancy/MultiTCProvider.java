package com.nucleus.multitenancy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.engine.jdbc.connections.spi.AbstractMultiTenantConnectionProvider;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;



public class MultiTCProvider extends AbstractMultiTenantConnectionProvider{

	private HashMap<String, ConnectionProvider> cp=new HashMap<String, ConnectionProvider>();

	public MultiTCProvider()
	{
		 List<String> providers=new ArrayList<String>();
		 providers.add("appDb");
		 providers.add("tenant1");
		 providers.add("tenant2");
		 for(String p:providers)
		 {
			 cp.put(p, new MyConnectionProvider(p));
		 }

		 
	}
	@Override
	protected ConnectionProvider getAnyConnectionProvider() {
		// TODO Auto-generated method stub
		return cp.get("appDb");
	}

	@Override
	protected ConnectionProvider selectConnectionProvider(String arg0) {
		// TODO Auto-generated method stub
		return cp.get(arg0);
	}

}
