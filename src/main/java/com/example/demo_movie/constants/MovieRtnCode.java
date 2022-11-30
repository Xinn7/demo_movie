package com.example.demo_movie.constants;

public enum MovieRtnCode {

	SUCCESSFUL("500","���\"),
	CANNOT_NULL_OR_EMPTY("400","���ରnull�Ϊ�"),
	MOVIE_CODE_IS_EXISTS("400","�q�v�N�X�w�s�b"),
	TIME("400","�榡���~");

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
