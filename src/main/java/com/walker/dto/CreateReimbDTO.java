package com.walker.dto;

public class CreateReimbDTO {
	private int author_id;
	private double amount;
	private String description;
	private int type_id;
	
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	
	@Override
	public String toString() {
		return "CreateReimbDTO [author_id=" + author_id + ", amount=" + amount + ", description=" + description
				+ ", type_id=" + type_id + "]";
	}
	
}
