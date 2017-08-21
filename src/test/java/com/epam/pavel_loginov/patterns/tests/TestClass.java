package com.epam.pavel_loginov.patterns.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.epam.pavel_loginov.patterns.business_objects.Letter;
import com.epam.pavel_loginov.patterns.pages.DraftPage;
import com.epam.pavel_loginov.patterns.pages.LetterPage;
import com.epam.pavel_loginov.patterns.pages.LoginPage;
import com.epam.pavel_loginov.patterns.pages.BasePage;
import com.epam.pavel_loginov.patterns.pages.SentMailsPage;
import com.epam.pavel_loginov.patterns.patterns.builder.FormalLetterBuilder;
import com.epam.pavel_loginov.patterns.patterns.builder.InformalLetterBuilder;
import com.epam.pavel_loginov.patterns.patterns.builder.LetterBuilder;
import com.epam.pavel_loginov.patterns.patterns.decorator.Decorator;
import com.epam.pavel_loginov.patterns.patterns.factory_method.DriverManager;
import com.epam.pavel_loginov.patterns.patterns.factory_method.WebDriverCreator;
import com.epam.pavel_loginov.patterns.patterns.singleton.SingletonDriver;

public class TestClass {

	Decorator driver;

	private LoginPage loginPage;
	private DraftPage draftPage;
	private LetterPage letterPage;
	private SentMailsPage sentPage;
	private BasePage currentPage;

	Letter letter;

	@BeforeClass(description = "start browser")
	@Parameters({ "browser" })
	public void setUp(String browserName) {

		WebDriverCreator driverCreator = DriverManager.getDriverCreatorByName(browserName.toLowerCase());

		driver = new Decorator(driverCreator.createDriver());
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {

		WebElement draftLink = currentPage.getDraftLink();
		draftLink.click();
		BasePage.logout();
		SingletonDriver.quit(driver);
	}

	@Test
	public void testLogin() {

		loginPage = new LoginPage(driver);
		currentPage = loginPage;
		loginPage.open();
		loginPage.login();

		WebElement userMenuBtn = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOfElementLocated(BasePage.USER_MENU_BTN_LOCATOR));

		Assert.assertEquals(userMenuBtn.getText(), "test_student2017@mail.ru");
	}

	@Test(dependsOnMethods = "testLogin", groups = "actionsWithLetters")
	public void draftTest() {

		draftPage = new DraftPage(driver);
		currentPage = draftPage;

		draftPage.composeLetter(letter);

		draftPage.saveDraft();

		draftPage.getDraftLink().click();
		driver.navigate().refresh();

		Assert.assertTrue(draftPage.findLetter(letter.getSubject()).isDisplayed());
	}

	@Test(dependsOnMethods = "draftTest", groups = "actionsWithLetters")
	public void contentTest() {

		letterPage = new LetterPage(driver);
		currentPage = letterPage;
		letterPage.getDraftLink().click();
		letterPage.openLetter(letter.getSubject());
		Assert.assertEquals(letterPage.getPageText(), letter.getText());
	}

	@Test(dependsOnMethods = "contentTest", groups = "actionsWithLetters")
	public void sendLetterTest() {
		letterPage.getDraftLink().click();
		letterPage.openLetter(letter.getSubject());
		letterPage.sendLetter();
		Assert.assertTrue(letterPage.isLetterSent());
	}

	@Test(dependsOnMethods = "sendLetterTest")
	public void isLetterSent() {
		sentPage = new SentMailsPage(driver);
		currentPage = sentPage;
		driver.navigate().refresh();
		Assert.assertTrue(sentPage.isLetterSent());
	}

	@BeforeGroups("actionsWithLetters")
	@Parameters("letterType")
	public void createLetter(String letterType) {

		LetterBuilder builder = null;
		if (letterType.equals("informal")) {
			builder = new InformalLetterBuilder();
			builder.build();

		} else if (letterType.equals("formal")) {
			builder = new FormalLetterBuilder();
			builder.build();

		} else {
			throw new RuntimeException("invalid parameter \"letterType\"");
		}

		letter = builder.getLetter();

	}

}
