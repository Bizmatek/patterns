package com.epam.pavel_loginov.patterns.tools;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Pavel_Loginov2<br>
 * CreatedDate - 2017 august 18<br>
 * Description - this class is intended for invoking data from .properties files
 * */

public class FileReader {
	
	/**
	 * CreatedDate - 2017 august 18<br>
	 * Description - method invokes set of properties from file by file name
	 * @param fileName name of the file which contains properties
	 * @return Properties set
	 * */
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
