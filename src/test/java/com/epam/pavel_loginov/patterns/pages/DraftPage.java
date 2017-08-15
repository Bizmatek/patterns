package com.epam.pavel_loginov.patterns.pages;

import java.util.Formatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.pavel_loginov.patterns.patterns.decorator.Decorator;

public class DraftPage extends Page {
	public DraftPage(WebDriver driver) {
		super(driver);

	}

	private static final By TO_TXT_AREA_LOCATOR = By.xpath("//textarea[contains(@data-original-name, 'To')]");
	private static final By SUBJ_INPUT_LOCATOR = By.xpath("//input[@class = 'b-input'][@name = 'Subject']");
	private static final By IFRAME_BODY_TXT_LOCATOR = By.xpath("//iframe[contains(@id, 'toolkit')]");
	private static final By BODY_LOCATOR = By.xpath("html/body");
	private static final By SAVE_BTN_LOCATOR = By
			.xpath("//div[@class = 'b-toolbar__item']//div[@class = 'b-dropdown__ctrl']");
	private static final By SAVE_DRAFT_BTN_LOCATOR = By.xpath("//span[text() = 'Сохранить черновик']");
	private static final By SAVE_STATUS_DIV_LOCATOR = By.xpath("//div[@data-mnemo = 'saveStatus']/a");

	public void composeLetter(String to, String subj, String letterText) {

		WebElement composeBtn = this.getCreateLetterBtn();
		composeBtn.click();

		WebElement toTxtArea = driver.findElement(TO_TXT_AREA_LOCATOR);
		toTxtArea.clear();

		WebElement subjInput = driver.findElement(SUBJ_INPUT_LOCATOR);
		subjInput.clear();

		Actions fillLetterHead = new Actions(((Decorator) driver).getInternalDriver());
		System.out.println("done");
		fillLetterHead.moveToElement(toTxtArea).click().sendKeys(to).moveToElement(subjInput).click().sendKeys(subj)
				.build().perform();

		WebElement letterBodyIFrame = driver.findElement(IFRAME_BODY_TXT_LOCATOR);
		driver.switchTo().frame(letterBodyIFrame);

		WebElement letterBody = driver.findElement(BODY_LOCATOR);
		letterBody.clear();
		letterBody.sendKeys(letterText);
		driver.switchTo().defaultContent();

	}

	public void saveDraft() {
		WebElement saveButton = getPageDriver().findElement(SAVE_BTN_LOCATOR);
		saveButton.click();

		WebElement saveDraftButton = getPageDriver().findElement(SAVE_DRAFT_BTN_LOCATOR);
		saveDraftButton.click();

		@SuppressWarnings("unused")
		WebElement saveStatus = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOfElementLocated(SAVE_STATUS_DIV_LOCATOR));
	}

	public WebElement findLetter(String subj) {
		Formatter formatter = new Formatter();
		formatter.format("(//a[@data-subject = '%s'])", subj);
		WebElement letter = driver.findElement(By.xpath(formatter.toString()));
		formatter.close();
		return letter;
	}
}
