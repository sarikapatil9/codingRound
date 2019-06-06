package cleartrip.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumAction extends BaseTest{
	
	public static void click(WebElement we){
		CustomWaits.waitForElementPresent(we);
		we.click();
	}
	
	public static void EnterTextUsingActions(WebElement we,String text){
		 Actions builder = new Actions(driver);
	     Actions seriesOfActions = builder.moveToElement(we).click().sendKeys(we,text);
	     seriesOfActions.perform();
	}
	public static void select(WebElement we,String text){
		new Select(we).selectByVisibleText(text);
	}
	
}
