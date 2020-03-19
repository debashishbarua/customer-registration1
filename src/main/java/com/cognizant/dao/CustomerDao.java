package com.cognizant.dao;

import java.util.List;

import com.cognizant.model.Customer;

public interface CustomerDao {
	
	public String create(Customer customer);
	
	public List<Customer> findAll();
}
