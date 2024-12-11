package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccoutsRegister;
import pageObjects.HomePage;

public class TC_001_Acc_Reg {
	public WebDriver driver;
	public Actions act;
	
	@BeforeClass
	public void setup() throws Exception
	{
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		
		act = new Actions(driver); 
		
	}

	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void verify_acc_register() throws Exception
	{

		HomePage hp = new HomePage(driver);
		hp.clickMyAcc();
		hp.clickReg();
	
		AccoutsRegister reg= new AccoutsRegister(driver);
		
		
		reg.setFirstname(randomString().toUpperCase());
		reg.setLastname(randomString().toUpperCase());
		reg.setEmail(randomString()+ "@gmail.com");
		reg.setTelephone(randomNumber());
		
		
		String password = randomAlphaNumber();
		
		reg.setPassword(password);
		reg.setCnfPassword(password);
		
		act.sendKeys(Keys.PAGE_DOWN).perform();
		WebElement checkbox = driver.findElement(By.xpath("//*[@type='checkbox']"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
	    
		reg.setContinue();
		
		String confmsg=reg.setConfirmMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
	}
	
	public String randomString()
	{
		
		String newcreatedstring= RandomStringUtils.randomAlphabetic(5);
		return newcreatedstring;
	}
	
	public String randomNumber()
	{
		
		String newcreatednumber = RandomStringUtils.randomNumeric(10);
		return newcreatednumber;
	}
	
	
	public String randomAlphaNumber()
	{
		
		
		String newcreatedstring = RandomStringUtils.randomAlphabetic(3);
		String newcreatednumber= RandomStringUtils.randomNumeric(3);
		return (newcreatedstring+newcreatednumber);
		
	}
}
