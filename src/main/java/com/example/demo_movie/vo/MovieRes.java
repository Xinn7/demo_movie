package com.example.demo_movie.vo;

import java.util.List;

import com.example.demo_movie.entity.Customers;
import com.example.demo_movie.entity.Movie;

public class MovieRes {

	private Movie movie;

	private Customers customers;

	private String message;
	
	List<Customers> orderList;

	public MovieRes() {

	}

	public MovieRes(String message) {
		this.message = message;
	}

	public MovieRes(Customers customers, String message) {
		this.customers = customers;
		this.message = message;
	}
	
	public MovieRes(Movie movie, String message) {
		this.movie = movie;
		this.message = message;
	}
	
	public MovieRes(List<Customers> orderList, String message) {
		this.orderList = orderList;
		this.message = message;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Customers> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Customers> orderList) {
		this.orderList = orderList;
	}

}
