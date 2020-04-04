package com.prueba.accenture.repository;

import java.util.List;

public interface Dao<T> {
	
	public T getById(String id);
    
    public List<T> getAll();
     
    public T create(T t);
     
    public void update(T t);
     
    public void delete(String id);
}
