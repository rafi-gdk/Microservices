package com.sonu.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sonu.beans.Product;

@Repository
@Transactional
public interface ProductRepository extends CrudRepository<Product,Integer>{

}
