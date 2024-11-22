package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

	public WebDriver ldriver;

	public RegistrationPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

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

	/*public String getPageTitle() {
		return ldriver.getTitle();
	}*/

	public void clickRegister() {
		ldriver.findElement(lnkRegister).click();
	}

	public void setFirstName(String fname) {

		ldriver.findElement(txtFirstName).clear();
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}

	public void setLastName(String lname) {
		ldriver.findElement(txtLastName).clear();
		ldriver.findElement(txtLastName).sendKeys(lname);
	}

	public void setPhone(String phone) {
		ldriver.findElement(txtPhone).clear();
		ldriver.findElement(txtPhone).sendKeys(phone);
	}

	public void setEmail(String email) {
		ldriver.findElement(txtEmail).clear();
		ldriver.findElement(txtEmail).sendKeys(email);
	}

	public void setAddress(String address) {
		ldriver.findElement(txtAddress).clear();
		ldriver.findElement(txtAddress).sendKeys(address);
	}

	public void setCity(String city) {
		ldriver.findElement(txtCity).clear();
		ldriver.findElement(txtCity).sendKeys(city);
	}

	public void setState(String state) {
		ldriver.findElement(txtState).clear();
		ldriver.findElement(txtState).sendKeys(state);
	}

	public void setPostalCode(String postalcode) {
		ldriver.findElement(txtPostalCode).clear();
		ldriver.findElement(txtPostalCode).sendKeys(postalcode);
	}

	public void setCountry(String value) {
		Select drp = new Select(ldriver.findElement(drpCountry));
		drp.selectByVisibleText(value);
	}

	public void setUserName(String username) {
		ldriver.findElement(txtUserName).clear();
		ldriver.findElement(txtUserName).sendKeys(username);
	}

	public void setPassword(String pass) {
		ldriver.findElement(txtPassword).clear();
		ldriver.findElement(txtPassword).sendKeys(pass);
	}

	public void setConfirmPassword(String confirmpass) {
		ldriver.findElement(txtConfirmPassword).clear();
		ldriver.findElement(txtConfirmPassword).sendKeys(confirmpass);
	}

	public void clickOnSubmit() {
		ldriver.findElement(btnSubmit).click();
	}

}
