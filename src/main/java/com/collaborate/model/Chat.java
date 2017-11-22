package com.collaborate.model;

//we are not added any annodation like @ entutu,@table because we are not persist chat in db
public class Chat 
{
	private String from;
	private String to;
	private String message;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
