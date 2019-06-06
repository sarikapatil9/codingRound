package cleartrip.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import cleartrip.util.SeleniumAction;
import cleartrip.util.Utilities;

public class HotelBookingPage extends Page{
	
	WebDriver driver;
	
	public HotelBookingPage(WebDriver rdriver){
		this.driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Hotels')]")
	private WebElement hotelLink;

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;
	
	@FindBy(xpath="//a[starts-with(@id,'ui-id')]")
	private WebElement selectfromlist;
	
	@FindBy(xpath="//a[@class='ui-state-default ui-state-highlight ui-state-active ']")
	private WebElement selectDate;
	
	@FindBy(xpath="//a[@class='ui-state-default ui-state-active ']")
	private WebElement selectToDate;

	
	
	public void clickOnHotelLink(){
		SeleniumAction.click(hotelLink);	
	}
	public void enterTextonHotelSearchBox(){
		SeleniumAction.EnterTextUsingActions(localityTextBox,"Indiranagar, Bangalore");	
	}
	
	public void clickOnSearch(){
		SeleniumAction.click(searchButton);	
	
	}
	public void clickOnselectedHotel(){
		SeleniumAction.click(selectfromlist);
	}
	
	public void selectFromDate(){
		SeleniumAction.click(selectDate);	
	}
	public void selectToDate(){
		SeleniumAction.click(selectToDate);	
	}
}
