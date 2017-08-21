package com.epam.pavel_loginov.patterns.patterns.factory_method;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.epam.pavel_loginov.patterns.patterns.singleton.SingletonDriver;

/** @author Pavel_Loginov2<br>
* 	CreatedDate - 2017 august 18<br>
* 	Description: Class for creation OperaDriver
*/

public class OperaDriverCreator extends WebDriverCreator {

	public WebDriver createDriver() {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setBrowserName("chrome");
		capabilities.setVersion("opera");

		capabilities.setPlatform(Platform.WINDOWS);

		driver = SingletonDriver.getInstance(capabilities);

		return driver;
	}
}
