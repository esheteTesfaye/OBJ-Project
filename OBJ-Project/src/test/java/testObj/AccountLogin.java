package testObj;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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

import ReadingFromFile.ReadDataFromExcelFile;


public class AccountLogin {
	WebDriver  driver;
	
	    
	   @BeforeMethod
		public void openingobj() {
		System.setProperty("webdriver.chrome.driver",utility.PathList.chromeDriver );
		driver = new ChromeDriver(); 
		driver.get("https://wild:grapes@preprod-obj.nxtdtc.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.switchTo().frame("_hjRemoteVarsFrame");
		driver.findElement(By.id("ltkpopup-close-button")).click();
		//driver.switchTo().defaultContent();
		}
		
		
		@AfterMethod
	    
		public void closeTheBrowser() {
			  //driver.close();	
			 	  
		}
		 @Test(dataProvider = "dp")
		  public void f(String n, String s) {
			  
			    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Close'])[1]/following::button[1]")).click();
			    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Journal'])[1]/following::p[1]")).click();
			    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Member of the CLX family of brands'])[1]/following::span[1]")).click();
			    driver.findElement(By.xpath("(//input[@name='email'])[2]")).clear();
			    driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("n");
			    driver.findElement(By.name("password")).clear();
			    driver.findElement(By.name("password")).sendKeys("s");
			    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='​'])[3]/following::span[3]")).click();
			    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
			 
		 }
		
		@Test 
		public void loginTestwithcorrectcredentials() {
		
		
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='$25.00'])[1]/following::span[2]")).click();
	     //driver.switchTo().frame("_hjRemoteVarsFrame");
	     
	     driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='-'])[1]/following::span[1]")).click();
	    
	     driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='$35.00'])[2]/following::span[1]")).click();
	     driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='-'])[1]/following::span[1]")).click();
	     driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='-'])[1]/following::span[1]")).click();
	     driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='-'])[1]/following::span[1]")).click();
	     driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='proceed to checkout'])[1]/following::span[1]")).click();
	     driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Tax is calculated at checkout'])[1]/following::span[1]")).click();
	     driver.findElement(By.xpath("(//input[@name='address-selector'])[10]")).click();
	     driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Add New Address'])[1]/following::span[1]")).click();
	     driver.findElement(By.xpath("(//input[@name='payment-method-selector'])[15]")).click();
	     driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::span[2]")).click();
	     driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Please take a moment to review your order.'])[1]/following::span[1]")).click();
	     driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='OBJ-UVF-4185-297339-2247'])[1]/following::span[1]")).click();
	     driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Delivered'])[1]/following::span[1]")).click();
	    
	     
	     //String Currenturl = driver.getCurrentUrl();
		//System.out.println(Currenturl);
		//Assert.assertEquals("https://preprod-obj.nxtdtc.com/gallery", "https://preprod-obj.nxtdtc.com/gallery" );
	     //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Close'])[1]/following::button[1]")).click();
	     //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Journal'])[1]/following::*[name()='svg'][2]")).click();
	     //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='YOUR ORDERS'])[1]/following::a[2]")).click();
	   
	  }
		
		 @DataProvider
		  public Object[][] dp() throws IOException {
			  // call a method to read from excel file
			  // store the record to two dimensional array
			  // return the array 
			    ReadDataFromExcelFile readExcelObject = new ReadDataFromExcelFile();
				 String filePath = "C:\\Users\\eshet\\eclipse-workspace\\DataDrivenPOIArtifactID\\src\\test\\java\\TestData\\Data.xlsx";
				 String[][] data = readExcelObject.readEcel(filePath, "Sheet1");
				 
				 return data; 

		
		/*@Test(dataProvider="emailandPassword")
		  public void loginTestwithwrongcredentials(String name, String password) {
			
			  driver.findElement(By.name("userName")).sendKeys(name);
			  driver.findElement(By.name("password")).sendKeys(password);
			  driver.findElement(By.name("login")).click();
		}
	 
		 @DataProvider
		   public  Object[][] userNameandPassword() {
		     Object[][] userNameAndPasswordObject= new Object[][] {
		   	     {"a", "dddddd"},
		    	 {"a", "dddddd"},
		    	 {"a", "dddddd"},
		    	 {"a", "dddddd"},
		    	 {"a", "dddddd"},
		    	 {"abcdef", "a"},
		    	 {"  ", "sdfsd"}
		  
		};

		     return userNameAndPasswordObject;   
		     
		 /*
		     private String closeAlertAndGetItsText() {
			        try {
			          Alert alert = driver.switchTo().alert();
			          String alertText = alert.getText();
			          if (acceptNextAlert) {
			            alert.accept();
			          } else {
			            alert.dismiss();
			          }
			          return alertText;
			        } finally {
			          acceptNextAlert = true;
			        }*/
	}
}
