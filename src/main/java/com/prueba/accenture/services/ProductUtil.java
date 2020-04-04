package com.prueba.accenture.services;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.prueba.accenture.dtos.ProductDTO;
import com.prueba.accenture.models.Product;

public class ProductUtil {

	public static List<Product> mapToProducts(String json) {

		Type type = new TypeToken<Map<String, ProductDTO>>() {}.getType();
		final Map<String, ProductDTO> productById = new Gson().fromJson(json, type);
		final List<Product> products = productById.entrySet().stream()
				.map(e -> {e.getValue().setName(e.getKey()); return e;})
				.map(e -> e.getValue())
				.map(dto -> mapDTOToProduct(dto))
				.collect(Collectors.toList());

		return products;
	}

	public static Product mapDTOToProduct(ProductDTO dto) {

		Product product = new Product();
		product.setName(dto.getName());
		product.setCategory(dto.getCategory());
		product.setDescription(dto.getDescription());
		product.setIdentification(dto.getIdentification());
		product.setInitDate(getDate(dto.getInitdate()));
		product.setInitDateAsString(dto.getInitdate());
		product.setProductName(dto.getProductname());
		product.setValue(dto.getValue());

		return product;
	}

	public static Date getDate(String date) {
		if (date == null)
			return null;

		DateFormat dateFormat = date.contains("-") ? new SimpleDateFormat("dd-MM-yyyy") : new SimpleDateFormat("MM/dd/yyyy");
		Date resultDate = null;

		try {
			resultDate = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return resultDate;
	}
}
