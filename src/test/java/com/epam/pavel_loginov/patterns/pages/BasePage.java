package com.epam.pavel_loginov.patterns.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.epam.pavel_loginov.patterns.patterns.decorator.Decorator;

/**
 * @author Pavel_Loginov2<br>
 * CreatedDate - 2017 august 18<br>
 * */

public class BasePage {

	@FindBy(xpath = "//span[text() =  'Черновики']")
	private static WebElement draftLink;

	@FindBy(xpath = "//a[@href='/messages/sent/']")
	private static WebElement sentLink;

	@FindBy(xpath = "//div[@id = 'LEGO']//a[@data-name = 'compose']")
	private static WebElement createLetterBtn;

	public static final By USER_MENU_BTN_LOCATOR = By.id("PH_user-email");

	protected static WebDriver driver;

	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Description - cleaning all data, which were created during tests.<br>
	 * CreatedDate - 2017 august 2017<br>
	 */

	public static void clean() {
		Actions action = new Actions(((Decorator) driver).getInternalDriver());
		action.sendKeys(Keys.chord(Keys.CONTROL, "a")).sendKeys(Keys.DELETE).build().perform();
	}

	public static void logout() {
		if (!((Decorator) driver).isElementPresent("//div[@class = 'b-datalist__empty']")) {
			clean();
		}
		driver.findElement(By.id("PH_logoutLink")).click();
	}

	public static WebDriver getPageDriver() {
		return (WebDriver) driver;
	}

	public WebElement getDraftLink() {
		return draftLink;
	}

	public WebElement getSentLink() {
		return sentLink;
	}

	public WebElement getCreateLetterBtn() {
		return createLetterBtn;
	}

	public By getUserMenuBtnLocator() {
		return USER_MENU_BTN_LOCATOR;
	}

	public WebElement getUserMenuBtn() {
		return driver.findElement(USER_MENU_BTN_LOCATOR);
	}
}
