package com.cognizant.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.config.AppConfig;
import com.cognizant.dao.CustomerDao;
import com.cognizant.dao.CustomerDaoImpl;

public class CustomerService {	
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		CustomerDao customerDao = ctx.getBean(CustomerDaoImpl.class, "customerDao");
		//String result = customerDao.create(new Customer(13L, "Akash", "Abc@gmail.com", "9677222265"));
		//System.out.println(result);
		System.out.println(customerDao);
		customerDao.findAll().forEach(System.out::println);
	}
}
