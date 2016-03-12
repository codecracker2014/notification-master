package com.nucleus.persistence;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MultiTenancyUtils {
	private String defaultSchema=null;

	public String getDefaultSchema() {
		return defaultSchema;
	}

	@Value("${DEFAULT_DATASOURCE}")
	public void setDefaultSchema(String defaultSchema) {
		System.out.println("setting");
		this.defaultSchema = defaultSchema;
	}

}
