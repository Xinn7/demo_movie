package com.example.demo_movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_movie.entity.Customers;

public interface CustomersDao extends JpaRepository<Customers, Integer>{

}
