import com.sun.javafx.PlatformUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignInTest {

	static WebDriver driver;
	static Properties prop=Utilities.prop;

	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() throws IOException{

		driver=Utilities.driverinitinalization(driver);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));

		driver.findElement(By.linkText("Your trips")).click();
		driver.findElement(By.id("SignIn")).click();
		driver.switchTo().frame("modal_window");

		String errors1 = driver.findElement(By.id("errors1")).getText();
		Assert.assertTrue(errors1.contains("There were errors in your submission"));
	}

	private void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
	}
	
	
	@AfterTest
	public void afterTestActions(){
		driver.quit();
	}
	
}
