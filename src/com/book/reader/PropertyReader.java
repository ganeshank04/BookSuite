package com.book.reader;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
	// private Properties prop;
	public static Properties getPropertyInstance(String fileName) {
		Properties prop = null;
		try {

			FileInputStream file = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(file);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

}
