package com.nucleus.multitenancy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.engine.jdbc.connections.internal.BasicConnectionCreator;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

public class MyConnectionProvider implements ConnectionProvider{

	private final BasicDataSource basicDataSource=new BasicDataSource();

	public MyConnectionProvider(String database)
	{
		  basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		  basicDataSource.setUrl("jdbc:mysql://localhost:3306/"+database);
		  basicDataSource.setUsername("root");
		  basicDataSource.setPassword("gk");
		  basicDataSource.setInitialSize(2);
		  //basicDataSource.setMaxTotal(10);

		
	}

	@Override
	public boolean isUnwrappableAs(Class arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeConnection(Connection arg0) throws SQLException {
		// TODO Auto-generated method stub
		arg0.close();
	}

	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return basicDataSource.getConnection();
	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

}
