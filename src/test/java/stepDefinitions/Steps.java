package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;

public class Steps {

	
	public WebDriver driver;
	public LoginPage lp;


	@Given("User Launch Edge browser")
	public void user_launch_edge_browser() {
		
		driver = new EdgeDriver();
		lp=new LoginPage(driver);

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {

		driver.get(url);

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

}
