package com.epam.pavel_loginov.patterns.business_objects;

import java.util.Properties;

import com.epam.pavel_loginov.patterns.tools.FileReader;

public class User {
	public User() {
		Properties property = new Properties(FileReader.getProperty("src/test/resources/User.properties"));
		this.setLogin(property.getProperty("login", DEFAULT_LOGIN));
		this.setPassword(property.getProperty("password", DEFAULT_PASSWORD));
	}

	private String login;
	private String password;
	private static final String DEFAULT_LOGIN = "test_student2017@mail.ru";
	private static final String DEFAULT_PASSWORD = "qwe123rty";

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
