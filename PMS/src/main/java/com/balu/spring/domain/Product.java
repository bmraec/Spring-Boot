package com.balu.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private String pid;
	private String name;
	private String description;
	private int stockQty;
	private double price;
	private String category;
	private String subCategory;
	private Gender gender;
	private PersonType personType;
}
