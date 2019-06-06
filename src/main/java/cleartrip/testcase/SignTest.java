package cleartrip.testcase;

import cleartrip.pages.FlightBookingPage;
import cleartrip.pages.HotelBookingPage;
import cleartrip.pages.SigninPage;
import  cleartrip.util.BaseTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import cleartrip.util.BaseTest;

@Listeners(cleartrip.testcase.TestNGListenerClass.class)
public class SignTest extends BaseTest{
	
	@Test(priority=1,groups={"signinTests","regression"},description="verify and error is displying"
			+ " we user signs in without usrename and password")
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() throws IOException, InterruptedException{

		
		SigninPage sign=new SigninPage(driver);
		
		sign.clickonYourTrip();
		sign.clickonSignin();
		
		driver.switchTo().frame("modal_window");
		sign.clickonsignininFrame();
		
		String errors1 = driver.findElement(By.id("errors1")).getText();
		Assert.assertTrue(errors1.contains("There were errors in your submission"));
		
	}
	
	@Test(priority=3,groups={"SearcforHotelTests","regression"},description="verify user is able to search for hotels")
	public void shouldBeAbleToSearchForHotels(){
		HotelBookingPage hotelBooking=new HotelBookingPage(driver);
		hotelBooking.clickOnHotelLink();
		hotelBooking.enterTextonHotelSearchBox();
		hotelBooking.clickOnselectedHotel();
		hotelBooking.selectFromDate();
		hotelBooking.selectToDate();
		hotelBooking.clickOnSearch();
		
	}
	
	@Test(priority=2,groups={"searchforflightsTests","regression"},description="verify user is able to search for flights")
	public void testThatResultsAppearForAOneWayJourney(){
		FlightBookingPage flightBooking=new FlightBookingPage(driver);
		flightBooking.clickOnoneWay();
		flightBooking.enterTextinFromField("bangalore");
		flightBooking.clickOnselectedfrom();
		flightBooking.enterTextinToField("del");
		flightBooking.clickOnselectedTo();
		
	}
	
}
