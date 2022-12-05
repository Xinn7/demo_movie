package com.example.demo_movie.constants;

public enum MovieRtnCode {

	SUCCESSFUL("500","成功"),
	PARAMS_ERROR("400","輸入錯誤，勿輸入0或負數且不能為null或空"),
	MOVIE_CODE_IS_EXISTS("400","電影代碼已存在"),
	MOVIE_NOT_EXISTS("400","電影不存在"),
	CUSTOMER_IS_EXISTS("400","帳號已存在"),
	TICKET_QUANTITY_ERROR("400","席位不足"),
	ORDER_LIST_IS_EMPTY("400","查無訂單資料");

	private String code;

	private String message;

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
