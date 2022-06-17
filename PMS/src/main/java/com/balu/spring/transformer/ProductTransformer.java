package com.balu.spring.transformer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.balu.spring.domain.Gender;
import com.balu.spring.domain.PersonType;
import com.balu.spring.domain.Product;
import com.balu.spring.entity.ProductEntity;

public class ProductTransformer {
	private ProductTransformer() {
	}

	public static Product transformProductEntity(ProductEntity entity) {
		if (entity != null) {
			return Product.builder().pid(entity.getPid()).name(entity.getName()).description(entity.getDescription())
					.stockQty(entity.getStockQty()).price(entity.getPrice()).category(entity.getCategory())
					.subCategory(entity.getSubCategory()).gender(Gender.valueOf(entity.getGender()))
					.personType(PersonType.valueOf(entity.getPersonType())).build();
		}
		return null;
	}

	public static List<Product> transformProductEntities(List<ProductEntity> entities) {
		if (entities != null && entities.size() > 0) {
			List<Product> products = new ArrayList<Product>();
			for (ProductEntity entity : entities) {
				products.add(transformProductEntity(entity));
			}
		}
		return Collections.emptyList();
	}

	public static ProductEntity transformProduct(Product product) {
		if (product != null) {
			return ProductEntity.builder().pid(product.getPid()).name(product.getName()).description(product.getDescription())
					.stockQty(product.getStockQty()).price(product.getPrice()).category(product.getCategory())
					.subCategory(product.getSubCategory()).gender(product.getGender().name())
					.personType(product.getPersonType().name()).build();
		}
		return null;
	}
}
