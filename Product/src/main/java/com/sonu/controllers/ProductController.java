package com.sonu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sonu.beans.Product;
import com.sonu.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	@RequestMapping("/getProduct/{id}")
	public Product getProduct(@PathVariable("id") Integer id)
	{
		return productService.getProduct(id);
	}
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public Product getProduct(@RequestBody Product product)
	{
		return productService.addProduct(product);
	}
}
