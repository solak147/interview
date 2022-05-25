package com.example.model;

import org.springframework.stereotype.Component;

@Component
public class TicketModel {
	
	private int no;
	private String type;
	private String serious;
	private String priority;
	private String solved;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSerious() {
		return serious;
	}
	public void setSerious(String serious) {
		this.serious = serious;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getSolved() {
		return solved;
	}
	public void setSolved(String solved) {
		this.solved = solved;
	}
	
	
	  

}
