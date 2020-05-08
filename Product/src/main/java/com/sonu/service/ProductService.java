package com.sonu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonu.beans.Product;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public Product getProduct(Integer id)
	{
		return productRepository.findById(id).get();
	}
	public Product addProduct(Product product)
	{
		return productRepository.save(product);
	}
}
