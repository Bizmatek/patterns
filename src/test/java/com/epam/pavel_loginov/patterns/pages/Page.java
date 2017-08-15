package com.epam.pavel_loginov.patterns.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.epam.pavel_loginov.patterns.patterns.decorator.Decorator;

public class Page {

	private static final By DRAFT_LINK_LOCATOR = By.xpath("//span[text() =  'Черновики']");
	private static final By SENT_LINK_LOCATOR = By.xpath("//a[@href='/messages/sent/']");
	private static final By CREATE_LETTER_BUTTON_LOCATOR = By.xpath("//div[@id = 'LEGO']//a[@data-name = 'compose']");
	public static final By USER_MENU_BTN_LOCATOR = By.id("PH_user-email");

	protected static WebDriver driver;

	public Page(WebDriver driver) {
		Page.driver = driver;
	}

	public static void logoutAndExit() {
		if (!((Decorator) driver).isElementExist("//div[@class = 'b-datalist__empty']")) {
			Actions action = new Actions(((Decorator) driver).getInternalDriver());
			action.sendKeys(Keys.chord(Keys.CONTROL, "a")).sendKeys(Keys.DELETE).build().perform();
		}
		driver.findElement(By.id("PH_logoutLink")).click();
		driver.close();
	}

	public static WebDriver getPageDriver() {
		return (WebDriver) driver;
	}

	public WebElement getDraftLink() {
		return driver.findElement(DRAFT_LINK_LOCATOR);
	}

	public WebElement getSentLink() {
		return driver.findElement(SENT_LINK_LOCATOR);
	}

	public WebElement getCreateLetterBtn() {
		return driver.findElement(CREATE_LETTER_BUTTON_LOCATOR);
	}

	public By getUserMenuBtnLocator() {
		return USER_MENU_BTN_LOCATOR;
	}

	public WebElement getUserMenuBtn() {
		return driver.findElement(USER_MENU_BTN_LOCATOR);
	}

	public static boolean isElementExist(String xpath) {

		try {
			driver.findElement(By.xpath(xpath));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
