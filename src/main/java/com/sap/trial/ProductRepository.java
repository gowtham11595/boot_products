package com.sap.trial;

import java.util.*;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
	private Map<String, Product> products = Collections.synchronizedMap(new HashMap<>());

	public Collection<Product> findAll(int offset, int count) {
		return products.values();
	}
	
	public void add(Product product) {
		products.put(product.getProductId(), product);
		
	}

	public Product find(String id) {
		System.out.println(products.get(id));
		return products.get(id);
	}

	public boolean exists(String id) {
		return products.containsKey(id);
	}
}
