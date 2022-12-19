package com.example.demo_movie.vo;

import java.time.LocalTime;
import java.util.List;

import com.example.demo_movie.entity.Customers;
import com.example.demo_movie.entity.Movie;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)

public class MovieRes {

	private Movie movie;

	private Customers customers;

	private String message;
	
	private List<Customers> orderList;
	
	private List<Movie> movieList;

	private Integer customerId;

	private String customerName;

	private String buyMovieCode;

	private Integer ticketQuantity;

	private Integer totalPrice;

	private MovieRes movieResList;
	
	private String movieName;

	private String movieCode;

	private String type;
	
	private String day;

	private LocalTime startTime;
	
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private int price;
	
	private String typeOrName;
	
	private String status;
	
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
	
	public MovieRes(String message, List<Movie> movieList) {
		this.movieList = movieList;
		this.message = message;
	}
	
	public MovieRes(MovieRes movieResList, String message) {
		this.movieResList = movieResList;
		this.message = message;
	}
	
	public MovieRes(String movieName, String movieCode, String day, String type,  
			LocalTime startTime, int price) {
		this.movieName = movieName;
		this.movieCode = movieCode;
		this.type = type;
		this.day = day;
		this.startTime = startTime;
		this.price = price;
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

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getBuyMovieCode() {
		return buyMovieCode;
	}

	public void setBuyMovieCode(String buyMovieCode) {
		this.buyMovieCode = buyMovieCode;
	}

	public Integer getTicketQuantity() {
		return ticketQuantity;
	}

	public void setTicketQuantity(Integer ticketQuantity) {
		this.ticketQuantity = ticketQuantity;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public MovieRes getMovieResList() {
		return movieResList;
	}

	public void setMovieResList(MovieRes movieResList) {
		this.movieResList = movieResList;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieCode() {
		return movieCode;
	}

	public void setMovieCode(String movieCode) {
		this.movieCode = movieCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTypeOrName() {
		return typeOrName;
	}

	public void setTypeOrName(String typeOrName) {
		this.typeOrName = typeOrName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
