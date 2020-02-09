package testObj;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class totalnumberofframesOBJ {
	
	static WebDriver driver; 
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",utility.PathList.chromeDriver );
		driver = new ChromeDriver();
    
	driver.get("https://wild:grapes@preprod-obj.nxtdtc.com");

	//By finding all the web elements using iframe tag
	//List<WebElement> iframeElements = driver.findElements(By.tagName("iframeResult"));
	//System.out.println("Total number of iframes are " + iframeElements.size());

	
	//By executing a java script
	JavascriptExecutor exe = (JavascriptExecutor) driver;
	Integer noOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
	System.out.println("No. of iframes on the page are " + noOfFrames);
}
}
