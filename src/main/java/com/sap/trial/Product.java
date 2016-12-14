package com.sap.trial;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
	
	private String productId;
	private String productCategory;
	private String productName;
	
	public Product(){
		
	}

	public String getProductId() {
		// TODO Auto-generated method stub
		return productId;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String toString(){
		return "{"+productId+", "+productName+", "+productCategory+"}";
	}
}
