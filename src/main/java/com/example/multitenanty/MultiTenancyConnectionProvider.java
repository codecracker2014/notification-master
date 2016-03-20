package com.example.multitenanty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.engine.jdbc.connections.spi.AbstractMultiTenantConnectionProvider;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

public class MultiTenancyConnectionProvider extends AbstractMultiTenantConnectionProvider{

	
	private HashMap<String, ConnectionProvider> connProviderMap=new HashMap<String, ConnectionProvider>();
	
	/**
	 * For getting default connection
	 * 
	 */
	public MultiTenancyConnectionProvider()
	{
		List<String> providerNames=new ArrayList<String>();
		providerNames.add("appDb");
		providerNames.add("tenant1");
		providerNames.add("tenant2");
		for (String providerName : providerNames) {
		       connProviderMap.put(providerName, new ConnectionProviderImpl(providerName));
		}
	}
	@Override
	protected ConnectionProvider getAnyConnectionProvider() {
		// TODO Auto-generated method stub
		System.out.println("Get Default connection");
		
		return connProviderMap.get("appDb");
	}
/**
 * For selecting connection
 */
	
	@Override
	protected ConnectionProvider selectConnectionProvider(String arg0) {
		// TODO Auto-generated method stub
		System.out.println("Selecting Db with id "+arg0);
		return connProviderMap.get(arg0);
	}

}
