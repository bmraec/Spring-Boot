package com.balu.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balu.spring.domain.Product;
import com.balu.spring.entity.ProductEntity;
import com.balu.spring.repo.ProductRepository;
import com.balu.spring.transformer.ProductTransformer;

@Service
public class ProductService {

	@Autowired
	private ProductRepository produRepository;

	public List<Product> getProducts() {
		List<ProductEntity> productsEntities = produRepository.findAll();
		return ProductTransformer.transformProductEntities(productsEntities);
	}

}
