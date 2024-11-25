package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	// Declare WebDriver instance variable
	public WebDriver driver;

	// Constructor to initialize WebDriver
	public WaitHelper(WebDriver driver) {
		this.driver = driver; // Initialize the WebDriver for the current instance
	}

	// Method to wait for an element to be visible on the page
	public void WaitForElement(WebElement element, long timeOutInSeconds) {
		// Create a WebDriverWait instance with the given timeout
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));

		// Wait until the element is visible on the page
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
