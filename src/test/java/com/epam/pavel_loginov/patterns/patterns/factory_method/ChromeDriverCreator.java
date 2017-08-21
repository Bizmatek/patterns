package com.epam.pavel_loginov.patterns.patterns.factory_method;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
	
	/** @author Pavel_Loginov2<br>
	* 	CreatedDate - 2017 august 18<br>
	* 	Description: Class for creation ChromeDriver
	*/

public class ChromeDriverCreator extends WebDriverCreator {

	@Override
	public WebDriver createDriver() {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setBrowserName("chrome");
		capabilities.setVersion("");

		capabilities.setPlatform(Platform.WINDOWS);

		try {
			driver = new RemoteWebDriver(new URL("http://localhost:2500/wd/hub"), capabilities);
			driver.manage().window().maximize();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return driver;
	}

}
