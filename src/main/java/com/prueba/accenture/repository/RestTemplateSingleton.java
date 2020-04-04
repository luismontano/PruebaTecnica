package com.prueba.accenture.repository;

import org.springframework.web.client.RestTemplate;

public final class RestTemplateSingleton {

	private static RestTemplate INSTANCE;
     
    private RestTemplateSingleton() {
    	
    }
     
    public static RestTemplate getInstance() {
        if(INSTANCE == null)
            INSTANCE = new RestTemplate();
         
        return INSTANCE;
    }
}
