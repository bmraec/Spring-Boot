package com.balu.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.balu.spring.domain.Product;
import com.balu.spring.entity.ProductEntity;
import com.balu.spring.repo.ProductRepository;
import com.balu.spring.transformer.ProductTransformer;

@Service
public class ProductService {

	@Autowired
	private ProductRepository produRepository;

	public List<Product> getProducts() {
		List<ProductEntity> productsEntities = produRepository.findAll(); // Getting all product
		return ProductTransformer.transformProductEntities(productsEntities); // Tranforming 
	}
	public Product addProduct(Product product) { // Adding Products
		ProductEntity entity = ProductTransformer.transformProduct(product);
		ProductEntity entity1 = produRepository.save(entity);
		Product product1= ProductTransformer.transformProductEntity(entity1);
		return product1; 
	}
	
	public Product searchById(String id) {
		 Optional<ProductEntity> entity = produRepository.findById(id);
		if(entity.isPresent()) {
			Product p1= ProductTransformer.transformProductEntity(entity.get());
			return p1;
		}
	return null;
	}
}
