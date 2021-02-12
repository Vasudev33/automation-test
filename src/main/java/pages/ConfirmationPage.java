package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends BasePage {

	public ConfirmationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h1[contains(text(), 'Thank you')]")
	private WebElement confirmMessage;
	@FindBy(xpath = "//td[text() = 'Id']")
	private WebElement IdTd;

	public void verifyBookingConfirmation() {
		verifyElementIsPresent(confirmMessage);
		verifyElementIsPresent(IdTd);
	}
}
