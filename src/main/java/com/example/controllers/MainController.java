package com.example.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dao.Dao;
import com.example.models.DemoEntity;
import com.example.multitenanty.MyCurrentTenantIdentifierResolver;


@Controller
public class MainController {

	
	@Autowired
	Dao dao;
	
	@RequestMapping(value="/welcome/{id}/{eid}")
	public String welcome(@PathVariable String id,@PathVariable String eid) {
		

		System.out.println("Called with "+id);
		MyCurrentTenantIdentifierResolver._tenantIdentifier.set(id);
		DemoEntity d=new DemoEntity();
		d.setId(eid);
		d.setName("gk");
		dao.save(d);
		return "welcome";
	}
}
