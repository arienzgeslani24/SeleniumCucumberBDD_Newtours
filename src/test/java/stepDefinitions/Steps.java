package stepDefinitions;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;

public class Steps extends BaseClass {

	
	//Login Page - Step Definitions

	@Given("User Launch Edge browser")
	public void user_launch_edge_browser() {

		driver = new EdgeDriver();
		lp = new LoginPage(driver);

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {

		driver.get(url);
	    driver.manage().window().maximize();

	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {

		if (driver.getPageSource().contains("Launching app was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}

	}

	@Then("close browser")
	public void close_browser() {

		driver.quit();

	}

	@When("User enters Username as {string} and Password as {string}")
	public void user_enters_username_as_and_password_as(String userName, String password) {

		lp.setUserName(userName);
		lp.setPassword(password);

	}

	@When("Click on Submit")
	public void click_on_submit() {

		lp.clickSubmit();

	}

	@When("User click on Signoff link")
	public void user_click_on_signoff_link() {

		lp.clickSignoff();

	}
	
	//Registration Page - Step Definitions

	@When("User click on Register link")
	public void user_click_on_register_link() {

		rp = new RegistrationPage(driver);
		rp.clickRegister();

	}

	@When("User enter customer info")
	public void user_enter_customer_info() {

		rp.setFirstName("autotest3");
		rp.setLastName("autotest3");
		rp.setPhone("1234");
		rp.setEmail("autotest3@gmail.com");

		rp.setAddress("3XXX Stotsentburg St.");
		rp.setCity("Caloocan");
		rp.setState("NCR");
		rp.setPostalCode("1234");

		rp.setCountry("PHILIPPINES");

		rp.setUserName("autotest3");
		rp.setPassword("autotest3");
		rp.setConfirmPassword("autotest3");

	}

	@When("click on Submit button")
	public void click_on_submit_button() {

		rp.clickOnSubmit();

	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {

		Assert.assertTrue(driver.findElement(By.xpath("//a[@href='login.php']")).getText().contains(string));

	}

}
