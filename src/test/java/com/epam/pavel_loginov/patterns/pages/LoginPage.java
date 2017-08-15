package com.epam.pavel_loginov.patterns.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.epam.pavel_loginov.patterns.business_objects.User;

public class LoginPage extends Page {

	public static final String LOGIN_PAGE_URL = "https://www.mail.ru/";
	public static final String LOGIN = "test_student2017";
	public static final String PASSWORD = "qwe123rty";
	private final By loginFieldLocator = By.xpath("//input[@name = 'Login']");
	private final By passwordFieldLocator = By.id("mailbox__password");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		getPageDriver().get(LOGIN_PAGE_URL);
	}

	public void login() {
		WebElement loginField = getPageDriver().findElement(loginFieldLocator);
		WebElement passwordField = getPageDriver().findElement(passwordFieldLocator);
		User user = new User();
		loginField.clear();
		loginField.sendKeys(user.getLogin());

		passwordField.clear();
		passwordField.sendKeys(user.getPassword());

		getPageDriver().findElement(By.id("mailbox__auth__button")).click();

	}
}
