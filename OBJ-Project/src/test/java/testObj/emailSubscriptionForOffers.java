package testObj;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class emailSubscriptionForOffers {

	WebDriver driver;

	String bodyText;

	@BeforeMethod
	public void openingobj() {
		System.setProperty("webdriver.chrome.driver", utility.PathList.chromeDriver);
		driver = new ChromeDriver();
		driver.get("https://wild:grapes@preprod-obj.nxtdtc.com");
		// driver.get("https://www.objectivewellness.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@AfterMethod

	public void closeTheBrowser() {
		driver.close();
	}

	@Test(dataProvider = "dp")
	public void newValidEmail(String email) {
		// driver.switchTo().frame("_hjRemoteVarsFrame");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("ltkpopup-email")).sendKeys("email");
		driver.findElement(By.id("ltkpopup-submit")).click();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.findElement(By.id("ltkpopup-close-button")).click();
		driver.findElement(By.tagName("body")).getText();
		// Assert.assertTrue(bodyText.contains(text));
		// Assert.assertTrue(driver.findElement(By.className("canelatext-light")).isDisplayed());

	}

	@Test(dataProvider = "dp")

	public void existingValidEmail() {
		// driver.switchTo().frame("_hjRemoteVarsFrame");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("ltkpopup-email")).sendKeys("email");
		driver.findElement(By.id("ltkpopup-submit")).click();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.findElement(By.id("ltkpopup-close-button")).click();

	}

	@Test(dataProvider = "dp")
	public void InValidEmail() {
		// driver.switchTo().frame("_hjRemoteVarsFrame");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("ltkpopup-email")).sendKeys("email");
		driver.findElement(By.id("ltkpopup-submit")).click();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.findElement(By.id("ltkpopup-close-button")).click();

	}

	/*
	 * @DataProvider public Object[][] dp() throws IOException { //Prepare the path
	 * of excel file String filePath =
	 * System.getProperty("user.dir")+"\\src\\test\\java\\testData\\TestCase.xlsx";
	 * //Call read file method of the class to read data String[][] dataFromExcel =
	 * ReadingFromExcell.readExcel(filePath,"dataForLogin",2,5,1,2); return
	 * dataFromExcel; //System.out.println(); //Assert /*if
	 * (driver.getCurrentUrl().equals(window)) return true; else {
	 * Thread.sleep(2000) tries++ }
	 */

	// driver.switchTo().defaultContent();
}
