package com.prueba.accenture.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.accenture.models.Product;
import com.prueba.accenture.models.ProductWrapper;
import com.prueba.accenture.services.Service;

@RestController
public class ProductController implements AccentureRestController<Product>{
	
	@Autowired
	private Service<Product> productService;
	
	@GetMapping("/products.json")
	public List<ProductWrapper> getAllProductsWrapped(){
		
		List<ProductWrapper> products = getAll()
				.stream()
				.map(p -> new ProductWrapper(p))
				.collect(Collectors.toList());
		
		return products;
	}
	
	@GetMapping("/products/{id}.json")
	public Product getById(@PathVariable("id") String id){
		return productService.getById(id);
	}
	
	@PostMapping(value = "/products.json")
	public String create(@RequestBody Product product) {
	    return productService.create(product).getName();
	}

	@PutMapping(value = "/products/{id}.json")
	public Product update(@RequestBody Product product, @PathVariable("id") String id) {
		product.setName(id);
		return productService.update(product);
	}

	@DeleteMapping(value = "/products/{id}.json")
	public Product delete(@PathVariable("id") String id) {
		Product a = productService.delete(id);
		return a;
	}
	
	@GetMapping("/totalvalues.json")
	public int getTotalValue(){
		return productService.getTotalValue();
	}
	
	public List<Product> getAll(){
		return productService.getAll();
	}
}
