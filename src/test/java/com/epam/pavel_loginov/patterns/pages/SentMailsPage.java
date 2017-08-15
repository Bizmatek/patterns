package com.epam.pavel_loginov.patterns.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SentMailsPage extends Page{
	public SentMailsPage(WebDriver driver){
		super(driver);
		this.getSentLink().click();
	}
	
	public boolean isLetterSent(){
		WebElement letterCaption = driver.findElement(By.xpath("(//div[@class = 'b-datalist__item__panel'])[1]"));
		return letterCaption.isDisplayed();
	}
}
