package com.sonu.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sonu.beans.Customer;
import com.sonu.beans.Product;
import com.sonu.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
public class CustomerController {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	CustomerService customerService;
	@Autowired
	Environment environment;
	
	@RequestMapping("/getCustomer/{id}")
	public Customer getCustomer(@RequestHeader Map<String,String> header,@PathVariable("id") Integer id) throws InterruptedException
	{
		String port = environment.getProperty("local.server.port");
		System.out.println("##########"+port+"########");
		Thread.sleep(100);
		return customerService.getCustomer(id);
	}
	@RequestMapping(value="/addCustomer",method=RequestMethod.POST)
	public Customer getCustomer(@RequestHeader Map<String,String> header,@RequestBody Customer customer)
	{
		return customerService.addCustomer(customer);
	}
	@RequestMapping(value="/getProduct/{id}")
	public Product getProduct(@RequestHeader Map<String,String> header, @PathVariable("id") Integer id)
	{
		return restTemplate.getForObject("http://product/product/getProduct/"+"id", Product.class);
	}
}
