package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchaseFlightPage extends BasePage {

	public PurchaseFlightPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//p[text() = 'Flight Number: UA954']")
	private WebElement flightNumber;
	@FindBy(xpath = "//input[@value = 'Purchase Flight']")
	private WebElement purchaseBTX;

	public void verifyFlightNumber() {
		verifyElementIsPresent(flightNumber);
	}

	public void purchaseFlight() {
		purchaseBTX.click();
	}
}
