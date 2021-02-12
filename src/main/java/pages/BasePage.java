package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.AllConstants;
import utils.Utility;

public class BasePage implements AllConstants {
	public WebDriver driver;
	public long lngETO;
	public Logger log;
	public WebDriverWait wait;

	@FindBy(xpath = "//a[text()='Travel The World']")
	private WebElement findPageLNK;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		String strETO = Utility.getPropertyValue(CONFIG_PATH, "ETO");
		lngETO = Long.parseLong(strETO);
		wait = new WebDriverWait(driver, lngETO);
		log = Logger.getLogger(this.getClass());
		PageFactory.initElements(driver, this);
	}

	public void clickFindPage() {
		log.info("Clicking on Find Flights page");
		Utility.sleep(2);
		findPageLNK.click();
	}

	public void verifyTitle(String eTitle) {
		log.info("Expected Title: " + eTitle);
		try {
			wait.until(ExpectedConditions.titleIs(eTitle));
			log.info("Title is matching");
		} catch (Exception e) {
			String aTitle = driver.getTitle();
			log.info("Actual Title: " + aTitle);
			log.info("Title is not matching");
			Assert.fail();
		}
	}

	public void verifyElementIsPresent(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			log.info("element is present");
		} catch (Exception e) {
			log.info("Element is not present");
			Assert.fail();
		}
	}
}
