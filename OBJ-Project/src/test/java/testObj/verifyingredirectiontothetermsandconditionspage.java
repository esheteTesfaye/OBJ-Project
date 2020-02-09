package testObj;

import org.openqa.selenium.WebElement;

public class verifyingredirectiontothetermsandconditionspage {
	
	
	@Test
    public void termsRedirectionTest()
    {
    	WebElement termsLink = driver.findElement(By.xpath("//a[contains(text(),'Terms')]"));
    	termsLink.click();    	
    	
    	Set <String> allWindows = driver.getWindowHandles();
    	
    	for(String handle : allWindows)
    	{
    		driver.switchTo().window(handle);
    	}    	        	
    	  	
    	String expectedURL = "https://www.lambdatest.com/terms-of-service";
    	String actualURL = driver.getCurrentUrl();
    	//System.out.println(actualURL);
    	Assert.assertEquals(actualURL, expectedURL);
    	
    	String expectedTitle = "Terms of Service - LambdaTest";
    	String actualTitle = driver.getTitle();
    	//System.out.println(actualTitle);
    	Assert.assertEquals(actualTitle, expectedTitle);    	
    }

//Verifying Privacy policy page redirection
    @Test
    public void privacyPolicyRedirectionTest()
    {
    	WebElement privacyPolicyLink = driver.findElement(By.xpath("//a[contains(text(),'Privacy')]"));
    	privacyPolicyLink.click();
    	
    	Set <String> allWindows = driver.getWindowHandles();
    	
    	for(String handle : allWindows)
    	{
    		driver.switchTo().window(handle);
    	}    	        	
    	  	
    	String expectedURL = "https://www.lambdatest.com/privacy";
    	String actualURL = driver.getCurrentUrl();
    	//System.out.println(actualURL);
    	Assert.assertEquals(actualURL, expectedURL);
    	
    	String expectedTitle = "Privacy Policy | LambdaTest";
    	String actualTitle = driver.getTitle();
    	//System.out.println(actualTitle);
    	Assert.assertEquals(actualTitle, expectedTitle);
    }    
    
    //Verifying redirection to the Login page from Registration page
    @Test
    public void loginRedirectionTest()
    {
    	WebElement loginLink = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
    	loginLink.click();
    	
    	String expectedURL = "https://accounts.lambdatest.com/login";
    	String actualURL = driver.getCurrentUrl();
    	//System.out.println(actualURL);
    	Assert.assertEquals(actualURL, expectedURL);
    	
    	String expectedTitle = "Login - LambdaTest";
    	String actualTitle = driver.getTitle();
    	//System.out.println(actualTitle);
    	Assert.assertEquals(actualTitle, expectedTitle);    	
    }
    
    //Verifying redirection to the landing page
    @Test
    public void landingPageRedirectionTest()
    {
    	WebElement lambdaTestLogo = driver.findElement(By.xpath("//p[@class='logo-home']//a//img"));
    	lambdaTestLogo.click();
    	
    	String expectedURL = "https://www.lambdatest.com/";
    	String actualURL = driver.getCurrentUrl();
    	Assert.assertEquals(actualURL, expectedURL);
    	
    	String expectedTitle = "";
    }

}
