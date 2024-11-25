package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

//import utilities.WaitHelper;

public class RegistrationPage {

	// WebDriver instance for interacting with the browser
	public WebDriver ldriver;

	// WaitHelper instance to manage wait actions for elements to appear or be ready
	//WaitHelper waithelper;

	// Constructor to initialize the WebDriver and set up the PageFactory and
	// WaitHelper
	public RegistrationPage(WebDriver rdriver) {
		ldriver = rdriver; // Assigning the passed WebDriver to the instance variable
		PageFactory.initElements(ldriver, this); // Initialize the PageFactory elements
		//waithelper = new WaitHelper(ldriver); // Initialize WaitHelper to handle waiting scenarios
	}

	// Locators for various elements on the registration page
	By lnkRegister = By.xpath("//a[@href='register.php']");
	By txtFirstName = By.xpath("//input[@name='firstName']");
	By txtLastName = By.xpath("//input[@name='lastName']");
	By txtPhone = By.xpath("//input[@name='phone']");
	By txtEmail = By.xpath("//input[@name='userName']");
	By txtAddress = By.xpath("//input[@name='address1']");
	By txtCity = By.xpath("//input[@name='city']");
	By txtState = By.xpath("//input[@name='state']");
	By txtPostalCode = By.xpath("//input[@name='postalCode']");
	By drpCountry = By.xpath("//select[@name='country']");
	By txtUserName = By.xpath("//input[@name='email']");
	By txtPassword = By.xpath("//input[@name='password']");
	By txtConfirmPassword = By.xpath("//input[@name='confirmPassword']");
	By btnSubmit = By.xpath("//input[@name='submit']");

	// Action Methods

	// Method to click the 'Register' link
	public void clickRegister() {
		//waithelper.WaitForElement(lnkRegister, 30);
		ldriver.findElement(lnkRegister).click(); // Click the Register link
	}

	// Method to set the first name field
	public void setFirstName(String fname) {
		ldriver.findElement(txtFirstName).clear(); // Clear any existing text
		ldriver.findElement(txtFirstName).sendKeys(fname); // Input the provided first name
	}

	// Method to set the last name field
	public void setLastName(String lname) {
		ldriver.findElement(txtLastName).clear(); // Clear any existing text
		ldriver.findElement(txtLastName).sendKeys(lname); // Input the provided last name
	}

	// Method to set the phone number field
	public void setPhone(String phone) {
		ldriver.findElement(txtPhone).clear(); // Clear any existing text
		ldriver.findElement(txtPhone).sendKeys(phone); // Input the provided phone number
	}

	// Method to set the email address field
	public void setEmail(String email) {
		ldriver.findElement(txtEmail).clear(); // Clear any existing text
		ldriver.findElement(txtEmail).sendKeys(email); // Input the provided email address
	}

	// Method to set the address field
	public void setAddress(String address) {
		ldriver.findElement(txtAddress).clear(); // Clear any existing text
		ldriver.findElement(txtAddress).sendKeys(address); // Input the provided address
	}

	// Method to set the city field
	public void setCity(String city) {
		ldriver.findElement(txtCity).clear(); // Clear any existing text
		ldriver.findElement(txtCity).sendKeys(city); // Input the provided city
	}

	// Method to set the state field
	public void setState(String state) {
		ldriver.findElement(txtState).clear(); // Clear any existing text
		ldriver.findElement(txtState).sendKeys(state); // Input the provided state
	}

	// Method to set the postal code field
	public void setPostalCode(String postalcode) {
		ldriver.findElement(txtPostalCode).clear(); // Clear any existing text
		ldriver.findElement(txtPostalCode).sendKeys(postalcode); // Input the provided postal code
	}

	// Method to select the country from the dropdown
	public void setCountry(String value) {
		Select drp = new Select(ldriver.findElement(drpCountry)); // Locate the dropdown
		drp.selectByVisibleText(value); // Select the country by visible text
	}

	// Method to set the username field
	public void setUserName(String username) {
		ldriver.findElement(txtUserName).clear(); // Clear any existing text
		ldriver.findElement(txtUserName).sendKeys(username); // Input the provided username
	}

	// Method to set the password field
	public void setPassword(String pass) {
		ldriver.findElement(txtPassword).clear(); // Clear any existing text
		ldriver.findElement(txtPassword).sendKeys(pass); // Input the provided password
	}

	// Method to set the confirm password field
	public void setConfirmPassword(String confirmpass) {
		ldriver.findElement(txtConfirmPassword).clear(); // Clear any existing text
		ldriver.findElement(txtConfirmPassword).sendKeys(confirmpass); // Input the provided confirm password
	}

	// Method to click the submit button
	public void clickOnSubmit() {
		ldriver.findElement(btnSubmit).click(); // Click the Submit button
	}
}
