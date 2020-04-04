package com.prueba.accenture.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
	
	@JsonIgnore
	private String name;
	
	private String category;
	
	private String description;
	
	private String identification;
	
	@JsonProperty("initdate")
	private String initDateAsString;
	
	@JsonIgnore
	private Date initDate;
	
	@JsonProperty("productname")
	private String productName;
	
	@JsonProperty("value")
	private Integer value;

	public Product(){
		
	}
	
	public Product(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getInitDateAsString() {
		return initDateAsString;
	}

	public void setInitDateAsString(String initDateAsString) {
		this.initDateAsString = initDateAsString;
	}

	public Date getInitDate() {
		return initDate;
	}

	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
