package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;

public class Steps extends BaseClass {

	// Login Page - Step Definitions

	// Step to launch Edge browser
	@Given("User Launch Edge browser")
	public void user_launch_edge_browser() {
		// Initializes EdgeDriver for launching the Edge browser
		driver = new EdgeDriver();
		// Creates an instance of LoginPage using the driver
		lp = new LoginPage(driver);
	}

	// Step to open the URL passed in the scenario
	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		// Navigates to the given URL
		driver.get(url);
		// Maximizes the browser window
		driver.manage().window().maximize();
	}

	// Step to verify the page title matches the expected title
	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
		// If the page contains the error message "Launching app was unsuccessful",
		// close the browser and fail the test
		if (driver.getPageSource().contains("Launching app was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false); // Test fails if this message is found
		} else {
			// Compare the actual page title with the expected title
			Assert.assertEquals(title, driver.getTitle());
		}
	}

	// Step to close the browser
	@Then("close browser")
	public void close_browser() {
		// Quits the driver and closes all browser windows
		driver.quit();
	}

	// Step to enter username and password
	@When("User enters Username as {string} and Password as {string}")
	public void user_enters_username_as_and_password_as(String userName, String password) {
		// Set the username and password using the respective page methods
		lp.setUserName(userName);
		lp.setPassword(password);
	}

	// Step to click on the Submit button
	@When("Click on Submit")
	public void click_on_submit() {
		// Calls the method to click the submit button on the LoginPage
		lp.clickSubmit();
	}

	// Step to click on the Signoff link
	@When("User click on Signoff link")
	public void user_click_on_signoff_link() {
		// Clicks the Signoff link
		lp.clickSignoff();
	}

	// Registration Page - Step Definitions

	// Step to click on the Register link
	@When("User click on Register link")
	public void user_click_on_register_link() {
		// Initializes the RegistrationPage and clicks the Register link
		rp = new RegistrationPage(driver);
		rp.clickRegister();
	}

	// Step to enter customer registration details
	@When("User enter customer info")
	public void user_enter_customer_info() {
		// Enters customer details for registration
		rp.setFirstName("autotest3");
		rp.setLastName("autotest3");
		rp.setPhone("1234");

		// Generates a random email using the randomstring() method
		String email = randomstring() + "@gmail.com";
		rp.setEmail(email);

		rp.setAddress("3XXX Stotsentburg St.");
		rp.setCity("Caloocan");
		rp.setState("NCR");
		rp.setPostalCode("1234");
		rp.setCountry("PHILIPPINES");

		// Setting up user credentials
		rp.setUserName("autotest3");
		rp.setPassword("autotest3");
		rp.setConfirmPassword("autotest3");
	}

	// Step to click on the Submit button for registration
	@When("click on Submit button")
	public void click_on_submit_button() {
		// Calls the method to click the submit button on the RegistrationPage
		rp.clickOnSubmit();
	}

	// Step to verify the confirmation message after successful registration
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
		// Asserts that the confirmation message is visible on the page
		Assert.assertTrue(driver.findElement(By.xpath("//a[@href='login.php']")).getText().contains(string));
	}
}
