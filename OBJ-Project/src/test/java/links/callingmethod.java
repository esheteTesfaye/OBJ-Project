package links;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class callingmethod {
	public static int brokenLinks;
	public static int validLinks;
	WebDriver driver;
	String url;

	@BeforeClass
	public void openobj() {

		url = "https://www.objectivewellness.com/journal";
		System.setProperty("webdriver.chrome.driver", utility.PathList.chromeDriver);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void closeTheBrowser() {
		driver.close();
	}

}
