package com.epam.pavel_loginov.patterns.patterns.factory_method;

public class DriverManager {

	public static WebDriverCreator getDriverCreatorByName(String name) {
		if (name.equals("firefox")) {
			return new FirefoxDriverCreator();
		} else if (name.equals("opera")) {
			return new OperaDriverCreator();
		} else if (name.equals("chrome")) {
			return new ChromeDriverCreator();
		} else {
			throw new RuntimeException("Driver error: " + name);
		}
	}

}
