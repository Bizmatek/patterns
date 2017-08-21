package com.epam.pavel_loginov.patterns.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.epam.pavel_loginov.patterns.business_objects.User;

public class LoginPage extends BasePage {

	public static final String LOGIN_PAGE_URL = "https://www.mail.ru/";
	public static final String LOGIN = "test_student2017";
	public static final String PASSWORD = "qwe123rty";
	
	@FindBy(xpath = "//input[@name = 'Login']")
	private static WebElement loginField;
	
	@FindBy(id = "mailbox__password")
	private static WebElement passwordField;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		getPageDriver().get(LOGIN_PAGE_URL);
	}

	public void login() {
		User user = new User();
		loginField.clear();
		loginField.sendKeys(user.getLogin());

		passwordField.clear();
		passwordField.sendKeys(user.getPassword());

		getPageDriver().findElement(By.id("mailbox__auth__button")).click();

	}
}
