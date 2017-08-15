package com.epam.pavel_loginov.patterns.patterns.factory_method;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.epam.pavel_loginov.patterns.patterns.singleton.MySingletonDriver;

public class FirefoxDriverCreator extends WebDriverCreator {

	@Override
	public WebDriver createDriver() {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setBrowserName("firefox");
		capabilities.setVersion("");

		capabilities.setPlatform(Platform.WINDOWS);
		driver = MySingletonDriver.getInstance(capabilities);

		return driver;
	}

}