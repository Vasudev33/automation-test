package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChooseFlightPage extends BasePage {

	public ChooseFlightPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h3[contains(text(), 'Boston to London')]")
	private WebElement message;

	public void verifyFlightsList() {
		verifyElementIsPresent(message);
	}

	public void chooseFlight(String flightNumber) {
		String chooseBTNXpath = "//td[text()='" + flightNumber + "']//preceding::input";
		driver.findElement(By.xpath(chooseBTNXpath)).click();
	}
}
