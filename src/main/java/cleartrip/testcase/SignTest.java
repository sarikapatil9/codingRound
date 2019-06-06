package cleartrip.testcase;

import cleartrip.pages.FlightBookingPage;
import cleartrip.pages.HotelBookingPage;
import cleartrip.pages.SigninPage;
import  cleartrip.util.BaseTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import cleartrip.util.BaseTest;

public class SignTest extends BaseTest{
	
	//@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() throws IOException, InterruptedException{

		
		SigninPage sign=new SigninPage(driver);
		
		sign.clickonYourTrip();
		sign.clickonSignin();
		
		driver.switchTo().frame("modal_window");
		sign.clickonsignininFrame();
		
		String errors1 = driver.findElement(By.id("errors1")).getText();
		Assert.assertTrue(errors1.contains("There were errors in your submission"));
		
	}
	
	//@Test
	public void shouldBeAbleToSearchForHotels(){
		HotelBookingPage hotelBooking=new HotelBookingPage(driver);
		hotelBooking.clickOnHotelLink();
		hotelBooking.enterTextonHotelSearchBox();
		hotelBooking.clickOnselectedHotel();
		hotelBooking.selectFromDate();
		hotelBooking.selectToDate();
		hotelBooking.clickOnSearch();
		
	}
	
	@Test 
	public void testThatResultsAppearForAOneWayJourney(){
		FlightBookingPage flightBooking=new FlightBookingPage(driver);
		flightBooking.clickOnoneWay();
		flightBooking.enterTextinFromField("bangalore");
		flightBooking.clickOnselectedfrom();
		flightBooking.enterTextinToField("del");
		flightBooking.clickOnselectedTo();
		
	}
	
}
