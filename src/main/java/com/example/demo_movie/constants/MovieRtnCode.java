package com.example.demo_movie.constants;

public enum MovieRtnCode {

	SUCCESSFUL("200", "成功"),
	PARAMS_ERROR("400", "輸入錯誤，勿輸入0或負數且不能為null或空"),
	MOVIE_CODE_IS_EXISTS("400", "電影代碼已存在"),
	MOVIE_NOT_EXISTS("400", "電影不存在"),
	CUSTOMER_IS_EXISTS("400", "帳號已存在"),
	TICKET_QUANTITY_ERROR("400", "席位不足"),
	ORDER_LIST_IS_EMPTY("400", "查無訂單資料"),
	MOVIE_CODE_NOT_EXSIST("400", "電影代碼不存在"),
	TICKET_SOLD_OUT("400", "票已售完"),
	TICKET_NOT_ENOUGH("400", "剩餘票數不足"),
	CUSTOMERID_NOT_EXSIST("400" ,"顧客代碼不存在"),
	MOVIE_EMPTY("400", "要查詢的電影名稱不能是空的"),
	TYPE_EMPTY("400", "要查詢的電影類型不能是空的"),
	TYPE_EXIST("400","查詢的電影類型不存在!!");


	private String code;

	private String message;
	
	private MovieRtnCode() {

	}

	private MovieRtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

