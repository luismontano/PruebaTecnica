package com.prueba.accenture.services;

import java.util.List;

import com.prueba.accenture.models.Product;

public interface Service<T> {

	public T getById(String id);
    
    public List<T> getAll();
     
    public T create(T t);
     
    public T update(T t);
     
    public Product delete(String id);
    
    public int getTotalValue();

	public int getTotalValue(List<Product> products);
}
