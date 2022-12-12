package com.example.demo_movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_movie.entity.Customers;

@Repository
public interface CustomersDao extends JpaRepository<Customers, Integer>{
	
	public List<Customers> findByCustomerName(String customerName);

}
