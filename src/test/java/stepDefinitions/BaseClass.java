package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;

public class BaseClass {

	// WebDriver instance for interacting with the browser in the tests
	public WebDriver driver;

	// Page Object instances for LoginPage and RegistrationPage
	public LoginPage lp;
	public RegistrationPage rp;

	// Method to generate a random string for unique email or other unique
	// identifiers
	// This uses the RandomStringUtils class from Apache Commons Lang
	public static String randomstring() {
		// Generates a random string of 5 alphabetic characters
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1); // Return the generated string
	}
}
