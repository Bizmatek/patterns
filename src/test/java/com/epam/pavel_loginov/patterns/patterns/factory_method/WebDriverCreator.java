package com.epam.pavel_loginov.patterns.patterns.factory_method;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverCreator {
	protected WebDriver driver;

	public abstract WebDriver createDriver();
}
