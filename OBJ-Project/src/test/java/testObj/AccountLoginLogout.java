package testObj;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AccountLoginLogout {
	static WebDriver driver; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",utility.PathList.chromeDriver );
	    driver = new ChromeDriver();
	    driver.get("https://wild:grapes@preprod-obj.nxtdtc.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.className("MuiTypography-root MuiTypography-body1")).click();
		driver.findElement(By.name("userName")).sendKeys("a");
		driver.findElement(By.name("password")).sendKeys("a");
		driver.findElement(By.name("login")).click(); 
	}

}
