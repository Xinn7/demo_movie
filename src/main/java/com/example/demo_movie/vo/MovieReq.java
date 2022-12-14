package com.example.demo_movie.vo;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieReq {

	@JsonProperty("movie_code")
	private String movieCode;

	@JsonProperty("movie_name")
	private String movieName;

	@JsonProperty("day")
	private String day;

	@JsonProperty("start_time")
	private LocalTime startTime;

	@JsonProperty("price")
	private int price;

	@JsonProperty("type")
	private String type;

	@JsonProperty("total_ticket")
	private int totalTicket;

	private int ticketBalance;

	@JsonProperty("id")
	private int id;

	@JsonProperty("customer_name")
	private String customerName;

	@JsonProperty("order_date")
	private LocalDateTime orderDate;

	@JsonProperty("ticket_quantity")
	private int ticketQuantity;

	@JsonProperty("total_price")
	private int totalPrice;

	@JsonProperty("verify")
	private boolean verify;

	@JsonProperty("type_or_movieName")
	private String typeOrMovieName;
	
	@JsonProperty("customer_id")
	private Integer customerId;
	
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

	public String getTypeOrMovieName() {
		return typeOrMovieName;
	}

	public void setTypeOrMovieName(String typeOrMovieName) {
		this.typeOrMovieName = typeOrMovieName;
	}
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
}
