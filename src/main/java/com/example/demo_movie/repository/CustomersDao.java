package com.example.demo_movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_movie.entity.Customers;

public interface CustomersDao extends JpaRepository<Customers, Integer>{
	
	public List<Customers> findByCustomerName(String customerName);

}
