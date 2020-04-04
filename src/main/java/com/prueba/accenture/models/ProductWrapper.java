package com.prueba.accenture.models;

import java.util.Collections;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductWrapper {

	@JsonIgnore
	private Product product;
	
	public ProductWrapper(Product product){
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@JsonAnyGetter
	public Map<String, Object> any() {
		return Collections.singletonMap(product.getName(), product);
	}
}
