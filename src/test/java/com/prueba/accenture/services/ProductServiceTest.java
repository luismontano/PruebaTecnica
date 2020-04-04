package com.prueba.accenture.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.accenture.models.Product;

@SpringBootTest
public class ProductServiceTest {

	@Autowired
	private Service<Product> productService;
	
	@Test
	public void getTotalValueTest() {
		assertEquals(0, productService.getTotalValue(null));
		assertEquals(0, productService.getTotalValue(new ArrayList<Product>()));
		assertEquals(1, productService.getTotalValue(valuesToProduct(1)));
		assertEquals(3, productService.getTotalValue(valuesToProduct(1, 2)));
		assertEquals(-1, productService.getTotalValue(valuesToProduct(-1)));
		assertEquals(-3, productService.getTotalValue(valuesToProduct(-1, -2)));
		assertEquals(0, productService.getTotalValue(valuesToProduct(-1, 1)));
	}

	private List<Product> valuesToProduct(Integer ... values) {
		return Arrays.stream(values).map(value -> {Product p = new Product(); p.setValue(value); return p;}).collect(Collectors.toList());
	}
}
