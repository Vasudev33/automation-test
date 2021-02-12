package scripts.web;

import org.testng.annotations.Test;

import pages.ChooseFlightPage;
import pages.ConfirmationPage;
import pages.FindFlightsPage;
import pages.PurchaseFlightPage;
import scripts.BaseTest;

public class VerifyBooking extends BaseTest {
	@Test
	public void testFlightBooking() {
		FindFlightsPage findPage = new FindFlightsPage(driver);
		findPage.verifyTitle("BlazeDemo");
		findPage.selectFromPort("Boston");
		findPage.selectToPort("London");
		findPage.clickFindBTN();

		ChooseFlightPage choosePage = new ChooseFlightPage(driver);
		choosePage.verifyTitle("BlazeDemo - reserve");
		log.info("Verify Flights List Getting Dispalyed");
		choosePage.verifyFlightsList();
		log.info("Selecting the flight");
		choosePage.chooseFlight("43");

		PurchaseFlightPage purchasePage = new PurchaseFlightPage(driver);
		purchasePage.verifyTitle("BlazeDemo Purchase");
		log.info("Verify Flight Number");
		purchasePage.verifyFlightNumber();
		purchasePage.purchaseFlight();

		ConfirmationPage confirmPage = new ConfirmationPage(driver);
		confirmPage.verifyTitle("BlazeDemo Confirmation");
		log.info("Verify flight booking confirmation");
		confirmPage.verifyBookingConfirmation();
	}

}
