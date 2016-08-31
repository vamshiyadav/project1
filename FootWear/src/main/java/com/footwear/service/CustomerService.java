package com.footwear.service;

import java.util.List;

import com.footwear.model.Customer;

public interface CustomerService {
	void addCustomer(Customer customer);
	List<Customer> viewCustomers();
	Customer getCustomerByName(String name);

}
