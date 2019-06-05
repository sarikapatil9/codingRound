import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;



public class FlightBookingTest {
	WebDriver driver;
	Properties prop=Utilities.prop;

	@BeforeTest
	public void beforeTestMethods(){
		try {
			driver=Utilities.driverinitinalization(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
		driver.get("https://www.cleartrip.com");
	}
	@Test
	public void testThatResultsAppearForAOneWayJourney() {


		//we can replace the id at a single place if it changes over time 
		String oneWayID="OneWay";
		String fromInputBoxID="FromTag";
		String toInputBoxID="ToTag";

		driver.findElement(By.id(oneWayID)).click();
		waitFor(2000);

		//send keys wasn't working in this so used actions class
		WebElement from=driver.findElement(By.id(fromInputBoxID));
		Actions builder = new Actions(driver);
		Actions seriesOfActions = builder.moveToElement(from).click().sendKeys(from, "bangalore");
		seriesOfActions.perform();

		//wait for the auto complete options to appear for the origin

		waitFor(2000);
		List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
		originOptions.get(0).click();

		//send keys wasn't working in this so used actions class
		WebElement to=driver.findElement(By.id(toInputBoxID));
		
		seriesOfActions = builder.moveToElement(to).click().sendKeys(to, "delhi");
		seriesOfActions.perform();
		
		//wait for the auto complete options to appear for the destination
		waitFor(2000);
		//select the first item from the destination auto complete list
		List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
		destinationOptions.get(0).click();

		WebElement selectDate=driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a"));
		WebElement searchButton=driver.findElement(By.id("SearchBtn"));
		
		

		selectDate.click();

		//all fields filled in. Now click on search
		searchButton.click();

		waitFor(5000);
		//verify that result appears for the provided journey search
		Assert.assertTrue(isElementPresent(By.className("searchSummary")));

	}


	private void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
	}


	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@AfterTest
	public void afterTestActions(){
		driver.quit();
	}


}
