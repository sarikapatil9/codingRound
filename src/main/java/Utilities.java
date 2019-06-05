import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Utilities {
	static Properties prop=new Properties();
	
	public static void loadProperties() throws IOException{
		Utilities utility=new Utilities();

		FileInputStream fs=new FileInputStream("C://Users//spatil9//Documents//GitHub//codingRound//Framework.properties");
		prop.load(fs);
	}

	//initialize driver
	public static WebDriver driverinitinalization(WebDriver driver) throws IOException{
		//place your all framework related test in a properties file
		loadProperties();
		setDriverPath();
		driver=new ChromeDriver();
		return driver;
	}

	private static void setDriverPath() {
		switch(prop.getProperty("URL")){
		case "windows":
			System.setProperty("webdriver.chrome.driver", "C://Users//spatil9//Documents//GitHub//codingRound//chromedriver.exe");
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
