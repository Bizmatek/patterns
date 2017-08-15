package com.epam.pavel_loginov.patterns.tools;

import java.io.FileInputStream;
import java.util.Properties;

public class FileReader {

	public static Properties getProperty(String fileName) {
		FileInputStream fis;
		Properties property = new Properties();
		try {
			fis = new FileInputStream(fileName);
			property.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return property;
	}
}
