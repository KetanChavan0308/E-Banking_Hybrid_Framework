package com.EBanking.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReading {
	public static String getProperties(String key) {
		String value = null;
		String projectPath = System.getProperty("user.dir");
		try {
			FileInputStream input = new FileInputStream(projectPath + "/Config File/PathFile.properties");
			Properties prop = new Properties();
			prop.load(input);
			value = prop.getProperty(key);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return value;
	}

	public static String getTestData(String key) {
		String value = null;
		String projectPath = System.getProperty("user.dir");
		try {
			FileInputStream input = new FileInputStream(projectPath + "/Config File/TestData.properties");
			Properties prop = new Properties();
			prop.load(input);
			value = prop.getProperty(key);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return value;

	}
}
