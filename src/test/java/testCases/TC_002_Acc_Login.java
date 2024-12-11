package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountLogin;
import pageObjects.HomePage;

public class TC_002_Acc_Login {
	public WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	@Test
	public void verify_acc_login()
	{
		HomePage hp2= new HomePage(driver);
		hp2.clickMyAcc();
		hp2.clickLogin();
		
		AccountLogin log= new AccountLogin(driver);
		log.setUsername("apmtestauto@gmail.com");
		log.setPassword("Apm@123");
		log.setLogin();
		String confmsg=log.setConf();
		Assert.assertEquals(confmsg, "My Account");
	}

}
