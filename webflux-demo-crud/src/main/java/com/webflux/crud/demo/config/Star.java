package com.webflux.crud.demo.config;

public class Star{
    Long id;
    String name;
    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

}
