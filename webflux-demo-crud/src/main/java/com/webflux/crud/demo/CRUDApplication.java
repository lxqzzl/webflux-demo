package com.webflux.crud.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@MapperScan({"com.webflux.demo.dao.*"} )
@EnableWebFlux
public class CRUDApplication {
	public static void main(String[] args) {
		SpringApplication.run(CRUDApplication.class, args);
	}
}