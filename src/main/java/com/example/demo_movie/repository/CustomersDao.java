package com.example.demo_movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo_movie.entity.Customers;

@Repository
public interface CustomersDao extends JpaRepository<Customers, Integer>{
	
	public List<Customers> findByCustomerName(String customerName);

	@Transactional
	@Modifying
	@Query("update Customers set status = 'expired' where order_date < :time and status = 'unpaid'")
	int updateStatus(@Param(value = "time") String time);
}
