package com.example.ecomm.util;

import java.time.LocalDateTime;

public class ResponseStructure<T> {
	
	private String msg;
	private int statusCode;
	private T data;
	private LocalDateTime dateTime = LocalDateTime.now();
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
