package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public RegistrationPage rp;

	// Created for generating random string for Unique email
	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}

}
