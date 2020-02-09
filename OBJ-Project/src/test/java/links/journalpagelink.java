package links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class journalpagelink {

	public static int brokenLinks;
	public static int validLinks;
	WebDriver driver;
	String url;

	@BeforeClass
	public void openobj() {

		// url = "https://www.objectivewellness.com/";
		System.setProperty("webdriver.chrome.driver", utility.PathList.chromeDriver);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// driver.findElement(By.className("optanon-alert-box-button
		// optanon-button-allow")).click();
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
			if (statusCode == 404) {
				++brokenLinks;
			} else {
				++validLinks;
			}
		}

		System.out.println("Total broken links found# " + brokenLinks);
		System.out.println("Total valid links found#" + validLinks);

	}

	@Test(dataProvider = "dp")
	public void testCheckLinks(String text, String link) {
		// Test to validate if a link URL is working or not
		int actualStatusCode = verifyURLStatus(link);
		org.testng.Assert.assertEquals(actualStatusCode, 200);

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
	public static int verifyURLStatus(String urlString1) {

		int status = 404;

		String url = null;
		if (urlString1 != null && !urlString1.isEmpty() && isValid(urlString1)) {
			url = urlString1;
		}

		if (url != null) {

			try {
				URL link = new URL(url);
				HttpURLConnection hConn = null;
				hConn = (HttpURLConnection) link.openConnection();
				hConn.setRequestMethod("GET");
				hConn.connect();
				status = hConn.getResponseCode();

				if (status != 200) {
					System.out.println("Not working--------------- Status =" + status);
				}

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		return status;

	}

	public static boolean isValid(String url) {
		/* Try creating a valid URL */
		try {
			System.out.println("before isValid...........>>>" + url);
			if (url.toLowerCase().contains("mailto".toLowerCase())) {
				System.out.println("invalid error..........." + url);
				return false;
			}
			new URL(url).toURI();
			return true;
		}

		// If there was an Exception
		// while creating URL object

		catch (Exception e) {
			System.out.println("invalid error..........." + url);
			return false;
		}
	}
}
