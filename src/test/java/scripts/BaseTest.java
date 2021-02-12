package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

import utils.AllConstants;
import utils.Utility;

public class BaseTest implements AllConstants {
	public WebDriver driver;
	public String strURL;
	public long lngITO;
	public Logger log = Logger.getLogger(this.getClass());

	@BeforeSuite
	public void initFrameWork() {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}

	@BeforeMethod
	public void openApp() {
		driver = new ChromeDriver();
		log.info("Opening Chrome Browser");
		strURL = Utility.getPropertyValue(CONFIG_PATH, "URL");
		driver.get(strURL);
		log.info("Enter the URL: " + strURL);
		String sITO = Utility.getPropertyValue(CONFIG_PATH, "ITO");
		log.info("Set ImplicitWait " + lngITO);
		lngITO = Long.parseLong(sITO);
		driver.manage().timeouts().implicitlyWait(lngITO, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void closeApp() {
		driver.quit();
		log.info("Close the Browser");
	}
}
