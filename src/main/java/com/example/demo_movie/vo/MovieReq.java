package com.example.demo_movie.vo;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class MovieReq {

	private String movieCode;

	private String movieName;

	private String day;

	private LocalTime startTime;

	private int price;

	private String type;

	private int totalTicket;

	private int ticketBalance;
	
	private int id;
	
	private String customerName;
	
	private LocalDateTime orderDate;
	
	private int ticketQuantity;
	
	private int totalPrice;
	
	private boolean verify;
	
	public MovieReq() {
		
	}

	public String getMovieCode() {
		return movieCode;
	}

	public void setMovieCode(String movieCode) {
		this.movieCode = movieCode;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTotalTicket() {
		return totalTicket;
	}

	public void setTotalTicket(int totalTicket) {
		this.totalTicket = totalTicket;
	}

	public int getTicketBalance() {
		return ticketBalance;
	}

	public void setTicketBalance(int ticketBalance) {
		this.ticketBalance = ticketBalance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public int getTicketQuantity() {
		return ticketQuantity;
	}

	public void setTicketQuantity(int ticketQuantity) {
		this.ticketQuantity = ticketQuantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isVerify() {
		return verify;
	}

	public void setVerify(boolean verify) {
		this.verify = verify;
	}
	
}
