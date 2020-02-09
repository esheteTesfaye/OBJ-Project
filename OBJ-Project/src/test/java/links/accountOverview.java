package links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class accountOverview {
	public static int brokenLinks;
	public static int validLinks;
	WebDriver driver;
    
	@BeforeMethod
	public void openobj () {

		
		System.setProperty("webdriver.chrome.driver",utility.PathList.chromeDriver );
		driver = new ChromeDriver();
		//driver.get("https://wild:grapes@preprod-obj.nxtdtc.com");
		driver.get("https://www.objectivewellness.com/account/overview");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("ltkpopup-close-button")).click();
	}
	@AfterMethod
	public void closeTheBrowser() {
		// driver.close();	
	}
		
	
	 @Test
	  public void accountLogin() {
		  
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Close'])[1]/following::button[1]")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Journal'])[1]/following::p[1]")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Member of the CLX family of brands'])[1]/following::span[1]")).click();
		    driver.findElement(By.xpath("(//input[@name='email'])[2]")).clear();
		    driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("testingobjective@gmail.com");
		    driver.findElement(By.name("password")).clear();
		    driver.findElement(By.name("password")).sendKeys("1234567");
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='​'])[3]/following::span[3]")).click();
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		    driver.findElement(By.className("MuiTypography-root MuiLink-root MuiLink-underlineHover MuiTypography-colorPrimary active")).click();
	 }
	@Test
	public void findbrokenlinks() {
		List<WebElement> allURLs = driver.findElements(By.tagName("a"));
		System.out.println("size:" + allURLs.size());
		
		validLinks = brokenLinks = 0;
		for (int iter = 0; iter < allURLs.size(); iter++) {
			System.out.println(allURLs.get(iter).getAttribute("href"));
			int statusCode = 0;
			try {
				statusCode = verifyURLStatus(allURLs.get(iter).getAttribute("href"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (statusCode == 404) {
				++brokenLinks;
			} else {
				++validLinks;
			}
		}

		System.out.println("Total broken links found# " + brokenLinks);
		System.out.println("Total valid links found#" + validLinks);

	}

	
	
	public static int verifyURLStatus(String urlString) {

		int status = 404;
		try {
			URL link = new URL(urlString);
			HttpURLConnection hConn = null;
			hConn = (HttpURLConnection) link.openConnection();
			hConn.setRequestMethod("GET");
			hConn.connect();
			status = hConn.getResponseCode();

		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return status;
	}

}



