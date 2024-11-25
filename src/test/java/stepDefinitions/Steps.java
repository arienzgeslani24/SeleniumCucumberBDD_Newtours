package stepDefinitions;

import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Steps extends BaseClass {
	
	
	@Before
	public void setup() throws IOException
	{
		
		//Reading Properties 
		configProp = new Properties();
		FileInputStream configPropfile=new FileInputStream("config.properties");
		configProp.load(configPropfile);
		
		logger = Logger.getLogger("Newtours"); 
		
		// Configure log4j properties
		PropertyConfigurator.configure("log4j.properties"); 
		
		
		String br=configProp.getProperty("browser");
		if(br.equals("chrome"))
		{
			// Initializes EdgeDriver for launching the Edge browser
			logger.info("Launching Chrome browser...");
			driver = new ChromeDriver();
			
		}
		if(br.equals("edge"))
		{
			// Initializes EdgeDriver for launching the Edge browser
			logger.info("Launching Edge browser...");
			driver = new EdgeDriver();
			
		}
		if(br.equals("firefox"))
		{
			// Initializes EdgeDriver for launching the Edge browser
			logger.info("Launching Firefox browser...");
			driver = new FirefoxDriver();
			
		}
	
	}

	// Login Page - Step Definitions

	// Step to launch Edge browser
	@Given("User Launch Edge browser")
	public void user_launch_edge_browser() {

		// Creates an instance of LoginPage using the driver
		lp = new LoginPage(driver);
		logger.info("Edge browser launched successfully and LoginPage object created.");

	}

	// Step to open the URL passed in the scenario
	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		// Navigates to the given URL
		logger.info("Opening URL: " + url);
		driver.get(url);
		// Maximizes the browser window
		driver.manage().window().maximize();
		logger.info("URL opened and browser window maximized.");
	}

	// Step to verify the page title matches the expected title
	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
		// If the page contains the error message "Launching app was unsuccessful",
		// close the browser and fail the test
		logger.info("Validating the page title...");
		if (driver.getPageSource().contains("Launching app was unsuccessful.")) {
			logger.error("Application launch failed. Closing the browser...");
			driver.close();
			Assert.assertTrue(false); // Test fails if this message is found
		} else {
			// Compare the actual page title with the expected title
			Assert.assertEquals(title, driver.getTitle());
			logger.info("Page title verified successfully: " + title);

		}
	}

	// Step to close the browser
	@Then("close browser")
	public void close_browser() {
		// Quits the driver and closes all browser windows
		logger.info("Closing the browser...");
		driver.quit();
		logger.info("Browser closed successfully.");

	}

	// Step to enter username and password
	@When("User enters Username as {string} and Password as {string}")
	public void user_enters_username_as_and_password_as(String userName, String password) {
		// Set the username and password using the respective page methods
		logger.info("Entering username and password...");
		lp.setUserName(userName);
		lp.setPassword(password);
		logger.info("Username and password entered successfully.");
	}

	// Step to click on the Submit button
	@When("Click on Submit")
	public void click_on_submit() {
		// Calls the method to click the submit button on the LoginPage
		logger.info("Clicking on the Submit button...");
		lp.clickSubmit();
		logger.info("Submit button clicked.");
	}

	// Step to click on the Signoff link
	@When("User click on Signoff link")
	public void user_click_on_signoff_link() {
		// Clicks the Signoff link
		logger.info("Clicking on the Signoff link...");
		lp.clickSignoff();
		logger.info("Signoff link clicked.");
	}

	// Registration Page - Step Definitions

	// Step to click on the Register link
	@When("User click on Register link")
	public void user_click_on_register_link() {
		// Initializes the RegistrationPage and clicks the Register link
		logger.info("Clicking on the Register link...");
		rp = new RegistrationPage(driver);
		rp.clickRegister();
		logger.info("Register link clicked.");
	}

	// Step to enter customer registration details
	@When("User enter customer info")
	public void user_enter_customer_info() {
		// Enters customer details for registration
		logger.info("Entering customer registration details...");
		rp.setFirstName("autotest3");
		rp.setLastName("autotest3");
		rp.setPhone("1234");

		// Generates a random email using the randomstring() method
		String email = randomstring() + "@gmail.com";
		rp.setEmail(email);
		logger.info("Generated random email: " + email);

		rp.setAddress("3XXX Stotsentburg St.");
		rp.setCity("Caloocan");
		rp.setState("NCR");
		rp.setPostalCode("1234");
		rp.setCountry("PHILIPPINES");

		// Setting up user credentials
		rp.setUserName("autotest3");
		rp.setPassword("autotest3");
		rp.setConfirmPassword("autotest3");
		logger.info("Customer registration details entered successfully.");
	}

	// Step to click on the Submit button for registration
	@When("click on Submit button")
	public void click_on_submit_button() {
		// Calls the method to click the submit button on the RegistrationPage
		logger.info("Clicking on the Submit button for registration...");
		rp.clickOnSubmit();
		logger.info("Submit button clicked for registration.");
	}

	// Step to verify the confirmation message after successful registration
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
		// Asserts that the confirmation message is visible on the page
		logger.info("Validating the confirmation message...");
		Assert.assertTrue(driver.findElement(By.xpath("//a[@href='login.php']")).getText().contains(string));
		logger.info("Confirmation message validated successfully: " + string);

	}
}
