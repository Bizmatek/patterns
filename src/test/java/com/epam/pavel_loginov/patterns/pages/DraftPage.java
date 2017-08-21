package com.epam.pavel_loginov.patterns.pages;

import java.util.Formatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.epam.pavel_loginov.patterns.business_objects.Letter;
import com.epam.pavel_loginov.patterns.patterns.decorator.Decorator;

/**
 * @author Pavel_Loginov2<br>
 * CreatedDate - 18 august 2017<br>
 * */

public class DraftPage extends BasePage {
	public DraftPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//textarea[contains(@data-original-name, 'To')]")
	private static WebElement toTxtArea;

	@FindBy(xpath = "//input[@class = 'b-input'][@name = 'Subject']")
	private WebElement subjInput;

	@FindBy(xpath = "//iframe[contains(@id, 'toolkit')]")
	private WebElement letterBodyIFrame;

	@FindBy(xpath = "html/body")
	private WebElement letterBody;

	@FindBy(xpath = "//div[@class = 'b-toolbar__item']//div[@class = 'b-dropdown__ctrl']")
	private WebElement saveButton;

	@FindBy(xpath = "//span[text() = 'Сохранить черновик']")
	private WebElement saveDraftButton;

	private static final By SAVE_STATUS_DIV_LOCATOR = By.xpath("//div[@data-mnemo = 'saveStatus']/a");

	
	/**
	 * Created date - 2017 august 2017<br>
	 * Description: filling of letter (destination address, subject and a text of letter)<br>
	 * @param letter a letter, which necessary to fill<br>
	 * */
	public void composeLetter(Letter letter) {

		WebElement composeBtn = this.getCreateLetterBtn();
		composeBtn.click();

		toTxtArea.clear();
		subjInput.clear();

		Actions fillLetterHead = new Actions(((Decorator) driver).getInternalDriver());
		fillLetterHead.moveToElement(toTxtArea).click().sendKeys(letter.getAddress()).moveToElement(subjInput).click()
				.sendKeys(letter.getSubject()).build().perform();

		driver.switchTo().frame(letterBodyIFrame);

		letterBody.clear();
		letterBody.sendKeys(letter.getText());
		driver.switchTo().defaultContent();

	}

	/**
	 * CreatedDate - 2017 august 18<br>
	 * Description - saving a editable letter in the "drafts" folder<br>
	 * */
	
	public void saveDraft() {
		saveButton.click();

		saveDraftButton.click();

		@SuppressWarnings("unused")
		WebElement saveStatus = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOfElementLocated(SAVE_STATUS_DIV_LOCATOR));
	}

	
	/**
	 * CreatedDate - 2017 august 18<br>
	 * Description - searching a letter by subject<br>
	 * @param subj keyword for search<br>
	 * @return Letter that matches the search criteria<br>
	 * */
	public WebElement findLetter(String subj) {
		Formatter formatter = new Formatter();
		formatter.format("(//a[@data-subject = '%s'])", subj);
		WebElement letter = driver.findElement(By.xpath(formatter.toString()));
		formatter.close();
		return letter;
	}
}
