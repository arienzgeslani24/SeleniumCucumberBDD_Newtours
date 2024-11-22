package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,  this);
	}
	@FindBy(xpath="//input[@name='userName']")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(xpath="//input[@name='password']")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@name='submit']")
	@CacheLookup
	WebElement btnSubmit;

	@FindBy(linkText="SIGN-OFF")
	@CacheLookup
	WebElement lnkSignoff;
	
	public void setUserName(String uname)
	{
		txtUserName.clear();
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		btnSubmit.click();
	}

	public void clickSignoff()
	{
		lnkSignoff.click();
	}


}
