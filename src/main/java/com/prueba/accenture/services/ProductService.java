package com.prueba.accenture.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prueba.accenture.models.Product;
import com.prueba.accenture.repository.Dao;

@Component
public class ProductService implements Service<Product> {

	@Autowired
	private Dao<Product> productDao;
	
	@Override
	public Product getById(String id) {
		return productDao.getById(id);
	}
	
	@Override
	public List<Product> getAll() {
		return productDao.getAll();
	}

	@Override
	public Product create(Product product) {
		return productDao.create(product);
	}

	@Override
	public Product update(Product product) {
		productDao.update(product);
		return getById(product.getName());
	}

	@Override
	public Product delete(String id) {
		productDao.delete(id);
		return getById(id);
	}

	@Override
	public int getTotalValue() {
		return getTotalValue(getAll());
	}

	@Override
	public int getTotalValue(List<Product> products) {
		if(products == null || products.isEmpty())
			return 0;
		
		return products.stream().map(p -> p.getValue()).reduce(0, (a,b) -> a + b);
	}
}
