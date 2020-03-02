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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class newHttp {

	public static int brokenLinks;
	public static int validLinks;
	WebDriver driver;
	String url;

	@BeforeClass
	public void openobj() {

		url = "https://www.stopagingnow.com/";
		// url = "https://www.thecloroxcompany.com/privacy/";
		System.setProperty("webdriver.chrome.driver", utility.PathList.chromeDriver);
		// System.setProperty("webdriver.gecko.driver",
		// utility.DriverPath.firefoxDriver);
		// driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void closeTheBrowser() {
		driver.close();
	}

	// @Test
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
			if (statusCode >= 200 && statusCode < 300) {
				++validLinks;
			} else {
				++brokenLinks;
			}
		}

		System.out.println("Total broken links found=============================# " + brokenLinks);
		System.out.println("Total valid links found...====================#" + validLinks);

	}

	@Test(dataProvider = "dp")
	public void testCheckLinks(String text, String link) {
		// Test to validate if a link URL is working or not
		String exp = "Not";
		int actualStatusCode = verifyURLStatus(link);

		if (actualStatusCode >= 200 && actualStatusCode < 300) {
			exp = "OK";
		}
		Assert.assertEquals(exp, "OK");

	}

	@DataProvider
	public Object[][] dp() throws IOException {

		// Call read file method of the class to read data
		String[][] alllinks = getAllLinksOfThePages(url);
		return alllinks;
	}

	private String[][] getAllLinksOfThePages(String url) {
		// Methods to find all a given URL

		driver.get(url);
		List<WebElement> allURLs = driver.findElements(By.tagName("a"));
		int size = allURLs.size();

		System.out.println("size:" + size);
		String[][] listoflinks = new String[size][2];

		validLinks = brokenLinks = 0;
		int count = 0;
		for (int iter = 0; iter < allURLs.size(); iter++) {
			String l;
			String n;
			try {
				l = allURLs.get(iter).getAttribute("href");
				n = allURLs.get(iter).getText();
				listoflinks[count][0] = n;
				listoflinks[count][1] = l;
				count++;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return listoflinks;
	}

	// @Test
	public static int verifyURLStatus(String urlString) {

		int status = 0;
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
