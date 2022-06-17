package com.balu.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {
	@Id
	@GenericGenerator(name = "product_id_generator", strategy = "com.balu.spring.id.ProductIdGenerator")
	@GeneratedValue(generator = "product_id_generator")
	private String pid;
	private String name;
	private String description;
	private int stockQty;
	private double price;
	private String category;
	private String subCategory;
	private String gender;
	private String personType;

}
