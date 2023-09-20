package com.in28minutes.microservice.currencyconversionmicroservice.model;

public class Todos {

	private int id;
	private String todo;
	private boolean completed;
	private int userId;

	public Todos(int id, String todo, boolean completed, int userId) {
		super();
		this.id = id;
		this.todo = todo;
		this.completed = completed;
		this.userId = userId;
	}

	public Todos() {
	}

	public int getId() {
		return id;
	}

	public String getTodo() {
		return todo;
	}

	public boolean isCompleted() {
		return completed;
	}

	public int getUserId() {
		return userId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
