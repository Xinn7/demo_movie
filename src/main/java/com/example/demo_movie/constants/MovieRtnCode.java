package com.example.demo_movie.constants;

public enum MovieRtnCode {

	SUCCESSFUL("500","成功"),
	CANNOT_NULL_OR_EMPTY("400","不能為null或空"),
	MOVIE_CODE_IS_EXISTS("400","電影代碼已存在"),
	TIME("400","格式錯誤");

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
