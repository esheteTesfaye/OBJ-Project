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

public class shopPagLink {
	
	public static int brokenLinks;
	public static int validLinks;
	WebDriver driver;
    
	@BeforeMethod
	public void openobj () {

		
		System.setProperty("webdriver.chrome.driver",utility.PathList.chromeDriver );
		driver = new ChromeDriver();
		//driver.get("https://wild:grapes@preprod-obj.nxtdtc.com");
		driver.get("https://www.objectivewellness.com/gallery");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void closeTheBrowser() {
		// driver.close();	
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

	
	@Test
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


