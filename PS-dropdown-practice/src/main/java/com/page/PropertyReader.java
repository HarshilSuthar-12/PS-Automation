package com.page;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	public String readProperty(String propertyName) {
		Properties properties = new Properties();
		String fileName = "C:\\Users\\sutha\\eclipse-workspace\\PS-dropdown-practice"
				+ "\\src\\main\\resources\\TestData\\testdata.properties";
		FileInputStream fis;
		try {
			fis = new FileInputStream(new File(fileName));
			try {
				properties.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String propertyValue = properties.getProperty(propertyName);
		return propertyValue;
	}
}
