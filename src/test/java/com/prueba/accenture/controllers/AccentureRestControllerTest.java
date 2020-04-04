package com.prueba.accenture.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.prueba.accenture.models.Product;
import com.prueba.accenture.repository.Dao;

@SpringBootTest
class AccentureRestControllerTest {

	@Autowired
	private Dao<Product> productService;
	
	@Autowired
	private AccentureRestController<Product> productRestController;
	
	@Test
	public void getProductsTest() {

		final List<Product> productsFromFireBase = productService.getAll();
		assertProducts(productsFromFireBase);
		
		final List<Product> productsFromDevelopedAPI = productRestController.getAll();
		assertProducts(productsFromDevelopedAPI);
		
		assertEqualsProducts(productsFromFireBase, productsFromDevelopedAPI);
	}
	
	@Test
	public void crudProductTest() {
		
		// Basic product
		final Product toCreateProduct = new Product();
		toCreateProduct.setCategory("Comida");
		toCreateProduct.setDescription("Saludable combinación de frutas");
		toCreateProduct.setIdentification("S1");
		toCreateProduct.setInitDateAsString("03-08-2020");
		toCreateProduct.setProductName("Ensalada de frutas");
		toCreateProduct.setValue(15000);
		
		// Create product
		final String json = productRestController.create(toCreateProduct);
		final Type type = new TypeToken<Map<String, String>>() {}.getType();
		final Map<String, String> nameId = new Gson().fromJson(json, type);
		final String id = nameId.values().stream().findFirst().orElse(null);

		// Get product
		Product productFromFireBase = productService.getById(id);
		assertProduct(productFromFireBase, false);
		
		Product productFromDevelopedAPI = productRestController.getById(id);
		assertProduct(productFromDevelopedAPI, false);
		
		assertEqualsProduct(productFromFireBase, toCreateProduct, false);
		assertEqualsProduct(productFromDevelopedAPI, toCreateProduct, false);
		assertEqualsProduct(productFromFireBase, productFromDevelopedAPI, true);
		
		// Update product
		final Product toUpdateProduct = productFromDevelopedAPI;
		toUpdateProduct.setCategory("Postre");
		toUpdateProduct.setDescription("Saludable combinación de frutas tropicales");
		toUpdateProduct.setIdentification("P1");
		toUpdateProduct.setInitDateAsString("03-08-2021");
		toUpdateProduct.setProductName("Ensalada de frutas tropicales");
		toUpdateProduct.setValue(20000);
		
		productRestController.update(toUpdateProduct, id);
		
		Product productUpdatedFromFireBase = productService.getById(id);
		assertProduct(productUpdatedFromFireBase, false);
		
		Product productUpdatedFromDevelopedAPI = productRestController.getById(id);
		assertProduct(productUpdatedFromDevelopedAPI, false);
		
		assertEqualsProduct(productUpdatedFromFireBase, toUpdateProduct, false);
		assertEqualsProduct(productUpdatedFromDevelopedAPI, toUpdateProduct, false);
		assertEqualsProduct(productUpdatedFromFireBase, productUpdatedFromDevelopedAPI, false);
		
		// Delete product
		productRestController.delete(id);
		
		Product productDeletedFromFireBase = productService.getById(id);
		assertNull(productDeletedFromFireBase);
		
		Product productDeletedFromDevelopedAPI = productRestController.getById(id);
		assertNull(productDeletedFromDevelopedAPI);
	}

	private void assertEqualsProducts(List<Product> expectedProducts, List<Product> currentProducts) {
		assertEquals(expectedProducts.size(), currentProducts.size());
		
		final Map<String, Product> currentProductByName = currentProducts.stream().collect(Collectors.toMap(p -> p.getName(), p -> p));
		
		for (Product expected : expectedProducts) {
			Product current = currentProductByName.get(expected.getName());
			assertEqualsProduct(expected, current, true);
		}
	}

	private void assertEqualsProduct(Product expected, Product current, boolean assertName) {
		assertNotNull(current);
		assertNotNull(expected);
		
		if(assertName)
			assertEquals(expected.getName(), current.getName());
		
		assertEquals(expected.getCategory(), current.getCategory());
		assertEquals(expected.getDescription(), current.getDescription());
		assertEquals(expected.getIdentification(), current.getIdentification());
		assertEquals(expected.getInitDateAsString(), current.getInitDateAsString());
		assertEquals(expected.getProductName(), current.getProductName());
		assertEquals(expected.getValue(), current.getValue());
	}

	private void assertProducts(List<Product> products) {
		assertNotNull(products);
		
		for(Product product : products)
			assertProduct(product, true);
	}

	private void assertProduct(Product product, boolean assertName) {
		assertNotNull(product);
		
		if(assertName)
			assertNotNull(product.getName());
		
		assertNotNull(product.getCategory());
		assertNotNull(product.getDescription());
		assertNotNull(product.getIdentification());
		assertNotNull(product.getInitDateAsString());
		assertNotNull(product.getProductName());
		assertNotNull(product.getValue());	
	}
}
