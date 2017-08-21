package com.epam.pavel_loginov.patterns.patterns.decorator;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Pavel_Loginov2<br>
 * CreatedDate - 2017 august 18<br>
 * Description: Class-decorator,  which decorates WebDriver functional
 */

public class Decorator implements WebDriver {
	protected WebDriver instance;

	public Decorator(WebDriver i) {
		instance = i;
	}

	public void close() {
		instance.close();

	}

	public WebElement findElement(By arg0) {

		System.out.println(arg0.toString());
		return instance.findElement(arg0);
	}

	public List<WebElement> findElements(By arg0) {

		return instance.findElements(arg0);
	}

	public void get(String arg0) {
		instance.get(arg0);

	}

	public String getCurrentUrl() {

		return instance.getCurrentUrl();
	}

	public String getPageSource() {

		return instance.getPageSource();
	}

	public String getTitle() {

		return instance.getTitle();
	}

	public String getWindowHandle() {

		return instance.getWindowHandle();
	}

	public Set<String> getWindowHandles() {

		return getWindowHandles();
	}

	public Options manage() {

		return instance.manage();
	}

	public Navigation navigate() {

		return instance.navigate();
	}

	public void quit() {

		instance.quit();
	}

	public TargetLocator switchTo() {

		return instance.switchTo();
	}

	public WebDriver getInternalDriver() {
		return instance;
	}

	/**
	 * CreatedDate - 2017 august 18<br>
	 * Description: Method, which determines if an element is present on the page<br>
	 * @param elementXpath xpath of element which you want to check
	 * @return true/false
	 * */
	
	public boolean isElementPresent(String elementXpath) {

		try {
			instance.findElement(By.xpath(elementXpath));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
