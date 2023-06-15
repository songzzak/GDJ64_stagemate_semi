package com.stagemate.common;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesGenerator {
	
	public static Properties by(String path) {
		Properties properties = new Properties();
		try (FileReader fileReader = new FileReader(path)) {
			properties.load(fileReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
