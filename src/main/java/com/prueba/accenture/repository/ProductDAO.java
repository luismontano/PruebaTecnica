package com.prueba.accenture.repository;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.prueba.accenture.models.Product;
import com.prueba.accenture.services.ProductUtil;

@Repository
public class ProductDAO implements Dao<Product>{
	
	private static final String BASE_URI = "https://testbankapi.firebaseio.com/products";

	@Override
	public Product getById(String id) {
		Product product = RestTemplateSingleton.getInstance().getForObject(BASE_URI + "/" + id + ".json", Product.class);
		return product;
	}

	@Override
	public List<Product> getAll() {
		String json = RestTemplateSingleton.getInstance().getForObject(BASE_URI + ".json", String.class);
		return ProductUtil.mapToProducts(json);
	}

	@Override
	public Product create(Product product) {
		ResponseEntity<String> response =  RestTemplateSingleton.getInstance().postForEntity(BASE_URI + ".json", product, String.class);
		return new Product(response.getBody());
	}

	@Override
	public void update(Product product) {
		String id = product.getName();
		RestTemplateSingleton.getInstance().put(BASE_URI + "/" + id + ".json", product, String.class);
	}

	@Override
	public void delete(String id) {
		RestTemplateSingleton.getInstance().delete(BASE_URI + "/" + id + ".json", Product.class);
	}
}
