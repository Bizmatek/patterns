package com.epam.pavel_loginov.patterns.pages;

import java.util.Formatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LetterPage extends Page {

	public LetterPage(WebDriver driver) {
		super(driver);
	}

	public final By bodyFrameLocator = By.xpath("//iframe[contains(@id, 'toolkit')]");
	public final By sendButtonLocator = By.xpath("//div[@data-name = 'send']");

	public void goIntoLetter(String subj) {
		Formatter formatter = new Formatter();
		formatter.format("(//a[@data-subject = '%s'])", subj); ////[1]
		WebElement letterCaption = driver.findElement(By.xpath(formatter.toString()));
		formatter.close();
		letterCaption.click();
	}

	public String getBodyText(String bodyText) {

		WebElement frame = driver.findElement(bodyFrameLocator);
		driver.switchTo().frame(frame);
		Formatter formatter = new Formatter();
		formatter.format("//*[contains(text(), '%s')]", bodyText);
		WebElement body = driver.findElement(By.xpath(formatter.toString()));
		formatter.close();
		String letterText = body.getText();
		driver.switchTo().defaultContent();
		return letterText;
	}

	public void sendLetter() {
		WebElement sendButton = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOfElementLocated(sendButtonLocator));
		sendButton.click();
	}

	public boolean isLetterSent() {
		WebElement sentMessageTitle = (new WebDriverWait(driver, 10)).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'message-sent__title']")));
		return sentMessageTitle.isDisplayed();
	}
}
