package com.footwear.dao;

import java.util.List;

import com.footwear.model.Customer;

public interface CustomerDao {
	void addCustomer(Customer customer);
	List<Customer> viewCustomers();
	Customer getCustomerByName(String name);

}
