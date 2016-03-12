package com.nucleus.persistence;

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitPostProcessor;

public class PersistenceScanner implements PersistenceUnitPostProcessor{

	
	@Override
	public void postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo mpu) {
		// TODO Auto-generated method stub
		System.out.println("PersistenceScanner"+mpu.getPersistenceUnitName());
		
		
	}

}
