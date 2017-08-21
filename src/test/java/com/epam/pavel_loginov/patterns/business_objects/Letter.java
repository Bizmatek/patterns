package com.epam.pavel_loginov.patterns.business_objects;

/**
 * @author Pavel_Loginov2<br>
 * CreatedDate - 2017 august 18<br>
 * */

public class Letter {

	private String address;
	private String subject;
	private String text;

	public String getAddress() {
		return address;
	}

	public String getSubject() {
		return subject;
	}

	public String getText() {
		return text;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setText(String text) {
		this.text = text;
	}

}
