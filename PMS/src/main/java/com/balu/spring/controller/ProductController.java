package com.balu.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balu.spring.domain.Product;
import com.balu.spring.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getProducts() {
		return productService.getProducts();
	}
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Product addProduct(@RequestBody   Product product) {
		return productService.addProduct(product);
	}
	
	
	@GetMapping(value = "/{pid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product searchById( @PathVariable("pid") String id) {
		System.out.println(id);
		return productService.searchById(id);
		
	}

}
