package com.walker.dto;

public class UpdateReimbDTO {
	private int id;
	private String explaination;
	private int resolver_id;
	private int status_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getExplaination() {
		return explaination;
	}
	public void setExplaination(String explaination) {
		this.explaination = explaination;
	}
	public int getResolver_id() {
		return resolver_id;
	}
	public void setResolver_id(int resolver_id) {
		this.resolver_id = resolver_id;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	
	@Override
	public String toString() {
		return "UpdateReimbDTO [id=" + id + ", explaination=" + explaination + ", resolver_id=" + resolver_id
				+ ", status_id=" + status_id + "]";
	}
	
}
