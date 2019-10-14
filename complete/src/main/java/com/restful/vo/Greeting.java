package com.restful.vo;

public class Greeting {

	private final long id;
	private final String name;
	private final String message;
	private final String templateString = "Hello, %s!";

	public Greeting(long id, String name) {
		this.id = id;
		this.name = name;
		this.message = String.format(templateString, name);
	}

	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public String getMessage() {
		return message;
	}
}
