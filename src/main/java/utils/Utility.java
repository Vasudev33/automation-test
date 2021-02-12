package utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.SkipException;

public class Utility {

	public static String getPropertyValue(String path, String key) {
		String value = "";
		try {
			Properties p = new Properties();
			p.load(new FileInputStream(path));
			value = p.getProperty(key);
		} catch (Exception e) {
			throw new SkipException("Config file not found");
		}
		return value;
	}

	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {

		}
	}
}
