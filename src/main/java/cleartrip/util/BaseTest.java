package cleartrip.util;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	public static WebDriver driver;
	
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
	
	//@AfterTest
	public void afterTestActions(){
		driver.quit();
	}
	

}
