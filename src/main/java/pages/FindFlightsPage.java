package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FindFlightsPage extends BasePage {
	public FindFlightsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//select[@name = 'fromPort']")
	private WebElement fromPortDD;
	@FindBy(xpath = "//select[@name = 'toPort']")
	private WebElement toPortDD;
	@FindBy(xpath = "//input[@type = 'submit']")
	private WebElement submitBTN;
	
	public void selectFromPort(String Country) {
		Select fromPort = new Select(fromPortDD);
		fromPort.selectByValue(Country);
		log.info("Selecting From Port");
	}

	public void selectToPort(String Country) {
		Select fromPort = new Select(toPortDD);
		fromPort.selectByValue(Country);
		log.info("Selecting To Port");
	}
	
	public void clickFindBTN() {
		submitBTN.click();
		log.info("Clicking Find Flights button");
	}
}
