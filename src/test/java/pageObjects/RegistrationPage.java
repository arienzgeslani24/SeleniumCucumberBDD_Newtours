package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	
public WebDriver ldriver;
	
	public RegistrationPage(WebDriver rdriver)
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
	
	//starts
	
	@FindBy(linkText="REGISTER")
	@CacheLookup
	WebElement lnkRegister;
	
	@FindBy(xpath="//input[@name='firstName']")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@name='lastName']")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@name='phone']")
	@CacheLookup
	WebElement txtPhone;
	
	@FindBy(xpath="//input[@name='userName']")
	@CacheLookup
	WebElement txtEmail;
	
	By drpCountry=By.xpath("//select[@name='country']");
	
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void setFirstName(String fname)
	{
		txtUserName.clear();
		txtUserName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtUserName.clear();
		txtUserName.sendKeys(lname);
	}
	
	public void setPhone(String phone)
	{
		txtUserName.clear();
		txtUserName.sendKeys(phone);
	}
	
	public void setAddress(String email)
	{
		txtUserName.clear();
		txtUserName.sendKeys(email);
	}
	public void setCity(String fname)
	{
		txtUserName.clear();
		txtUserName.sendKeys(fname);
	}
	
	public void setState(String lname)
	{
		txtUserName.clear();
		txtUserName.sendKeys(lname);
	}
	
	public void setPostalCode(String phone)
	{
		txtUserName.clear();
		txtUserName.sendKeys(phone);
	}
	
	public void setEmail(String email)
	{
		txtUserName.clear();
		txtUserName.sendKeys(email);
	}
	
    public void setCountry(String value)
    {
        Select drp=new Select(ldriver.findElement(drpCountry));
        drp.selectByVisibleText(value);
    }

	
	//end
	
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
