package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
@FindBy(xpath="(//*[@class=\"hidden-xs hidden-sm hidden-md\"])[3]")
WebElement lnkMyAcc;


@FindBy(xpath="//a[normalize-space()='Register']") //Commented for clicking on login directly
WebElement lnkReg;

@FindBy(xpath="//a[normalize-space()='Login']")
WebElement linkLogin;

public void clickMyAcc()
{
	lnkMyAcc.click();	
}
public void clickReg()
{
	lnkReg.click();
}

public void clickLogin()
{
	linkLogin.click();
}

}
