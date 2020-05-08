package com.sonu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonu.beans.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public Customer getCustomer(Integer id)
	{
		return customerRepository.findById(id).get();
	}
	public Customer addCustomer(Customer customer)
	{
		return customerRepository.save(customer);
	}
}
