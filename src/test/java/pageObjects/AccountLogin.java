package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLogin extends BasePage{

	public AccountLogin(WebDriver driver) {
		super(driver);
		
	}

	
@FindBy(xpath="//input[@name=\"email\"]")
WebElement txtUser;
@FindBy(xpath="//*[@name=\"password\"]")
WebElement txtPasswd;
@FindBy(xpath="//input[@type=\"submit\"]")
WebElement btnLogin;
@FindBy(xpath="//*[@id=\"content\"]/h2[1]")
WebElement msgConf;

public void setUsername(String uname)
{
	txtUser.sendKeys(uname);
}
public void setPassword(String passwd)
{
	txtPasswd.sendKeys(passwd);
}
public void setLogin()
{
	btnLogin.click();
}
public String setConf()
{
	try {
		return (msgConf.getText());
	}catch(Exception e) {
		return (e.getMessage());
	}
	
	
}
}
