package testObj;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class email {
	
	    
		public static void main(String[] args) {
	    System.setProperty("webdriver.gecko.driver",utility.PathList.firefoxDriver );
	    WebDriver  driver = new FirefoxDriver(); 
		//driver.get("https://wild:grapes@preprod-obj.nxtdtc.com/");
		driver.get("https://www.objectivewellness.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	    //driver.switchTo().frame("_hjRemoteVarsFrame");
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("ltkpopup-email")).sendKeys("testingobjective@gmail.com");
		driver.findElement(By.id("ltkpopup-submit")).click();
		Assert.assertTrue(driver.findElement(By.className("canelatext-light")).isDisplayed());
		
		WebElement msg=driver.findElement(By.id("ltkpopup-headline"));
		String text=msg.getText();
		if (msg.isEnabled() && text.contains("Got it!"))
		{ 
		    System.out.println("Successfully completed");
		}else{
		    System.out.println("Please enter all details");
		}
		
		
		//String bodyText = driver.findElement(By.className("canelatext-light")).getText();
		//Assert.assertTrue(bodyText.contains("Youre on the list"));
		//System.out.println(bodyText);
		
		/*String title = driver.getTitle();
	    if(title.contains("Got it!"))

	        System.out.println("Email Subscribed");

	    else {

	        System.out.println("I am broken!");
		
	    }
}*/

		}
}
		