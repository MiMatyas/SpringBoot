package com.matyas.Shop;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NameService {
    @Value("${name}")
    private String name;
    NameService(){

    }

@PostConstruct
    public void sayMyName(){
        System.out.println(name);
    }
}