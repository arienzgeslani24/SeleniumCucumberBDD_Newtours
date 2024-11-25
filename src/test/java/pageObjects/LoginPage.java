package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// Declare WebDriver instance to interact with the browser
	public WebDriver ldriver;

	// Constructor to initialize the WebDriver and set up the PageFactory
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver; // Assign the passed WebDriver to the instance variable
		PageFactory.initElements(rdriver, this); // Initialize the WebElements using the WebDriver
	}

	// Locate the username input field using XPath and cache the result
	@FindBy(xpath = "//input[@name='userName']")
	@CacheLookup
	WebElement txtUserName;

	// Locate the password input field using XPath and cache the result
	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	WebElement txtPassword;

	// Locate the submit button using XPath and cache the result
	@FindBy(xpath = "//input[@name='submit']")
	@CacheLookup
	WebElement btnSubmit;

	// Locate the Sign-Off link using the link text and cache the result
	@FindBy(linkText = "SIGN-OFF")
	@CacheLookup
	WebElement lnkSignoff;

	// Method to clear the username field and input a new username
	public void setUserName(String uname) {
		txtUserName.clear(); // Clear any existing text in the username field
		txtUserName.sendKeys(uname); // Input the provided username
	}

	// Method to clear the password field and input a new password
	public void setPassword(String pwd) {
		txtPassword.clear(); // Clear any existing text in the password field
		txtPassword.sendKeys(pwd); // Input the provided password
	}

	// Method to click the submit button
	public void clickSubmit() {
		btnSubmit.click(); // Click the submit button
	}

	// Method to click the Sign-Off link
	public void clickSignoff() {
		lnkSignoff.click(); // Click the Sign-Off link
	}
}
