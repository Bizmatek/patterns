package com.epam.pavel_loginov.patterns.pages;

import java.util.Formatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Pavel_Loginov2<br>
 * CreatedDate - 2017 august 18<br>
 */

public class LetterPage extends BasePage {

	public LetterPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//iframe[contains(@id, 'toolkit')]")
	public static WebElement bodyFrame;

	public static final By sendButtonLocator = By.xpath("//div[@data-name = 'send']");

	/**
	 * Description - Method opening a letter, which satisfy by search
	 * criteria<br>
	 * CreatedDate - 2017 august 18<br>
	 * 
	 * @param subj
	 *            theme of the letter which necessary to open
	 */

	public void openLetter(String subj) {
		Formatter formatter = new Formatter();
		formatter.format("(//a[@data-subject = '%s'])", subj);
		WebElement letterCaption = driver.findElement(By.xpath(formatter.toString()));
		formatter.close();
		letterCaption.click();
	}

	
	/**
	 * Description - Method, which returns text of opened letter<br>
	 * CreatedDate - 2017 august 18<br>
	 * @return letterText text of the letter<br>
	 * */
	
	public String getPageText() {
		driver.switchTo().frame(bodyFrame);
		WebElement body = driver.findElement(By.xpath("html/body/div/div/div"));
		String letterText = body.getText();
		driver.switchTo().defaultContent();
		return letterText;
	}
	

	public void sendLetter() {
		WebElement sendButton = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOfElementLocated(sendButtonLocator));
		sendButton.click();
	}

	/**
	 * Description - Method, which check that letter is sent<br>
	 * CreatedDate - 2017 august 18<br>
	 * @return Are there any messages about sending a message? (boolean)
	 * */
	
	public boolean isLetterSent() {
		WebElement sentMessageTitle = (new WebDriverWait(driver, 10)).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'message-sent__title']")));
		return sentMessageTitle.isDisplayed();
	}
}
