package cleartrip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cleartrip.util.SeleniumAction;

public class FlightBookingPage extends Page{
	WebDriver driver;
	
	public FlightBookingPage(WebDriver rdriver){
		this.driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="OneWay")
	private WebElement OneWay;
	
	@FindBy(id="FromTag")
	private WebElement fromField;
	
	@FindBy(id="ToTag")
	private WebElement toField;
	
	@FindBy(xpath="//a[starts-with(@id,'ui-id')]")
	private WebElement selectfromlist;
	
	@FindBy(xpath="//a[starts-with(@id,'ui-id') and contains(text(),'New')]")
	private WebElement selecttolist;
	
	public void clickOnoneWay(){
		SeleniumAction.click(OneWay);	
	
	}
	public void enterTextinFromField(String text){
		SeleniumAction.EnterTextUsingActions(fromField,text);	
	}
	public void enterTextinToField(String text){
		SeleniumAction.EnterTextUsingActions(toField,text);	
	}
	public void clickOnselectedfrom(){
		SeleniumAction.click(selectfromlist);
	}
	public void clickOnselectedTo(){
		SeleniumAction.click(selecttolist);
	}
	
}
