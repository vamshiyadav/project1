package com.footwear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footwear.dao.CustomerDao;
import com.footwear.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}
	public List<Customer> viewCustomers() {
		List<Customer>list=customerDao.viewCustomers();
		return list;
	}
	public Customer getCustomerByName(String name) {
		return customerDao.getCustomerByName(name);
		
	}

}
