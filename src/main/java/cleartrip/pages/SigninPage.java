package cleartrip.pages;

import cleartrip.util.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cleartrip.util.SeleniumAction;

public class SigninPage extends Page {
	WebDriver driver;
	
	public SigninPage(WebDriver rdriver){
		this.driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText = "Your trips")
	private WebElement YourTrip;
	
	@FindBy(id = "SignIn")
	private WebElement signin;
	
	@FindBy(id = "signInButton")
	private WebElement signInButton;
	
	
	public void clickonYourTrip(){
		SeleniumAction.click(YourTrip);
	}
	public void clickonsignininFrame(){
		SeleniumAction.click(signInButton);
	}
	
	public void clickonSignin(){
		SeleniumAction.click(signin);
	}
	
	
}
