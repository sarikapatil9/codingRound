import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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
	static Properties prop=new Properties();
	
	@BeforeTest
	public void driverinitinalization() throws IOException{
		//place your all framework related test in a properties file
		FileInputStream fs=new FileInputStream("Framework.properties");
		prop.load(fs);
		setDriverPath();
		driver=new ChromeDriver();
	}

	@Test
	public void testThatResultsAppearForAOneWayJourney() {
		
		System.out.println("---------------------Url: "+prop.getProperty("URL"));
		driver.get(prop.getProperty("URL"));
		waitFor(2000);
	
		//we can replace the id if it changes over time at a single place
		String oneWayID="OneWay";
		String fromInputBoxID="FromTag";
		String toInputBoxID="ToTag";
		

		
		driver.findElement(By.id(oneWayID)).click();
		waitFor(2000);
		
		driver.findElement(By.id(fromInputBoxID)).clear();
		driver.findElement(By.id(fromInputBoxID)).sendKeys("bangalore");

		//wait for the auto complete options to appear for the origin

		waitFor(2000);
		List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
		originOptions.get(0).click();

		
		driver.findElement(By.id(toInputBoxID)).clear();
		driver.findElement(By.id(toInputBoxID)).sendKeys("delhi");

		//wait for the auto complete options to appear for the destination

		waitFor(2000);
		
		WebElement selectDate=driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a"));
		WebElement searchButton=driver.findElement(By.id("SearchBtn"));
		
		//select the first item from the destination auto complete list
		List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
		destinationOptions.get(0).click();

		selectDate.click();

		//all fields filled in. Now click on search
		searchButton.click();

		waitFor(5000);
		//verify that result appears for the provided journey search
		Assert.assertTrue(isElementPresent(By.className("searchSummary")));

		//close the browser
		driver.quit();

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

	private void setDriverPath() {
		switch(prop.getProperty("URL")){
			case "windows":
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				break;
			case "mac":
				System.setProperty("webdriver.chrome.driver", "chromedriver");
				break;
			case "linux":
				System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
			default :
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				break;
		}
	}
}
