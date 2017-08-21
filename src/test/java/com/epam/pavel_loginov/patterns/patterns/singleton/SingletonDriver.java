package com.epam.pavel_loginov.patterns.patterns.singleton;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.epam.pavel_loginov.patterns.tools.FileReader;

public class SingletonDriver {
	private static final String DEFAULT_HUB_URL = "http://localhost:4444/wd/hub";

	private SingletonDriver() {
	}

	private static WebDriver instance = null;
	
	public static synchronized WebDriver getInstance(DesiredCapabilities capabilities) {
		if (instance == null) {
			try {
				Properties property = new Properties(FileReader.getProperty("src/test/resources/config.properties"));
				instance = new RemoteWebDriver(new URL(property.getProperty("hub.url", DEFAULT_HUB_URL)), capabilities);
				instance.manage().window().maximize();
				instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	public static void quit(WebDriver driver){
		driver.quit();
		instance = null;
	}
}
