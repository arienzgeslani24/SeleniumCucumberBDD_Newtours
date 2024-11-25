package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import java.util.Properties;

public class BaseClass {

	// WebDriver instance for interacting with the browser in the tests
	public WebDriver driver;

	// Page Object instances for LoginPage, RegistrationPage, Logger and Properties
	public LoginPage lp;
	public RegistrationPage rp;
	public static Logger logger;
	public Properties configProp;

	// Method to generate a random string for unique email or other unique
	// identifiers
	// This uses the RandomStringUtils class from Apache Commons Lang
	public static String randomstring() {
		// Generates a random string of 5 alphabetic characters
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1); // Return the generated string
	}
}
