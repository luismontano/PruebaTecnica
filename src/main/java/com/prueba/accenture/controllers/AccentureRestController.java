package com.prueba.accenture.controllers;

import java.util.List;

public interface AccentureRestController<T> {
	
	public T getById(String id);
    
    public List<T> getAll();
     
    public String create(T t);
     
    public T update(T t, String id);
     
    public T delete(String id);
    
    public int getTotalValue();
}
