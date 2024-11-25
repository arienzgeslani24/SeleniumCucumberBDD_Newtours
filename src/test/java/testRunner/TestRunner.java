package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;

// This annotation tells JUnit to run the tests with Cucumber
@RunWith(Cucumber.class)

// Cucumber options configuration
@CucumberOptions(
		// Specifies the location of the feature files (test scenarios in Gherkin
		// format)
		features = "src/test/resources/Features/",

		// Specifies the package where step definition methods are defined
		glue = "stepDefinitions",

		// If set to 'true', the test will only check for the existence of the step
		// definitions without running the tests (used for debugging)
		dryRun = false,

		// If set to 'true', Cucumber will print the output in a more readable format
		monochrome = true,

		// Specifies the plugins for generating reports in different formats (pretty,
		// html, json, junit)
		plugin = { "pretty", // Provides a pretty format in the console
				"html:target/HtmlReports/cucumber-reports.html", // Generates an HTML report
				"json:target/JSONReports/report.json", // Generates a JSON report
				"junit:target/JUnitReports/report.xml" // Generates a JUnit XML report for integration with CI tools
		},

		// Tags filter to execute specific scenarios with the tag 
		tags = "@Sanity"
		)
public class TestRunner {
	// This class is used to configure and run the Cucumber tests. It acts as the
	// entry point for the test execution.
}
