import com.sun.javafx.PlatformUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HotelBookingTest {

	WebDriver driver;
	static Properties prop=Utilities.prop;

	@FindBy(xpath="//a[contains(text(),'Hotels')]")
	private WebElement hotelLink;

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;
	
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
	public void shouldBeAbleToSearchForHotels() throws InterruptedException {
		
		hotelLink.click();
		
		//send keys wasn't working in this so used actions class
		Utilities.setText(localityTextBox,"Indiranagar, Bangalore");
		
		new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
		searchButton.click();
	}
	
	@AfterTest
	public void afterTestActions(){
		driver.quit();
	}
	
}
