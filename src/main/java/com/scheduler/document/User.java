package com.scheduler.document;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class User {

	@Id
	private String id;
	private int userId;

	public User(int userId) {
		this.userId = userId;
	}

}
