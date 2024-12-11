package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccoutsRegister extends BasePage {

	public AccoutsRegister(WebDriver driver) {
		super(driver);
	
	}
	
@FindBy(xpath="//input[@name=\"firstname\"]")
WebElement txtFirstname;
@FindBy(xpath="//input[@name=\"lastname\"]")
WebElement txtLastname;
@FindBy(xpath="//input[@name=\"email\"]")
WebElement txtEmail;
@FindBy(xpath="//input[@name=\"telephone\"]")
WebElement txtTelephone;
@FindBy(xpath="//input[@name=\"password\"]")
WebElement txtPwd;
@FindBy(xpath="//input[@name=\"confirm\"]")
WebElement txtCnfPwd;
@FindBy(xpath="//*[@type=\"checkbox\"]")
WebElement chkbox;
@FindBy(xpath="//*[@type='submit']")
WebElement btnContinue;
@FindBy(xpath="//*[@id=\"content\"]/h1")
WebElement msgConfirm;

public void setFirstname(String fname)
{
	txtFirstname.sendKeys(fname);
}
public void setLastname(String lname)
{
	txtLastname.sendKeys(lname);
}
public void setEmail(String email)
{
	txtEmail.sendKeys(email);
}
public void setTelephone(String telephone)
{
	txtTelephone.sendKeys(telephone);
}
public void setPassword(String pwd)
{
	txtPwd.sendKeys(pwd);
}
public void setCnfPassword(String cnfpwd)
{
	txtCnfPwd.sendKeys(cnfpwd);
}
public void setCheckBox()
{
	chkbox.click();
}
public void setContinue()
{
	btnContinue.click();
}
public String setConfirmMsg()
{
	try {
		return(msgConfirm.getText());
	} catch (Exception e) {
		return (e.getMessage());
	}
}
}

