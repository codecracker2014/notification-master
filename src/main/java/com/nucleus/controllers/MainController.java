package com.nucleus.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nucleus.models.DemoEntity;
import com.nucleus.multitenancy.TenantService;
import com.nucleus.persistence.SpringUtils;


@Controller
public class MainController {

	
	@RequestMapping(value="/welcome/{id}")
	public String welcome(@PathVariable String id) {
		
		System.out.println("Called with "+id);
	//	tenantService.setTenantSchemaName(id);
		final ApplicationContext applicationContext=SpringUtils.getSpringContext();
		TenantService tenantService=null;
		if(applicationContext==null)
		{
			System.out.println("context is null");
			throw new IllegalStateException();
		}
		tenantService=applicationContext.getBean(TenantService.class);
		if(tenantService==null)
		{
			System.out.println("tsc is null");
			throw new IllegalStateException();
		}
		tenantService.setTenantSchemaName(id);
		
		DemoEntity d=new DemoEntity();
		d.setId("123");
		d.setName("gk");
		
		EntityManagerFactory emf=(EntityManagerFactory)applicationContext.getBean("entityManagerFactory");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
	//	em.persist(d);
		em.getTransaction().commit();
		em.close();
		return "welcome";
	}
}
