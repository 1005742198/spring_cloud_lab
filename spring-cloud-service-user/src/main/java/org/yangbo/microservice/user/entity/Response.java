package org.yangbo.microservice.user.entity;

public class Response<T> {
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
