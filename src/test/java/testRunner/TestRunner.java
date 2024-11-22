package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features/", 
		glue = "stepDefinitions",
		dryRun=false,
		monochrome = true, 
		plugin = {
				"pretty",
				"html:target/HtmlReports/cucumber-reports.html",
				"json:target/JSONReports/report.json",
				"junit:target/JUnitReports/report.xml"},
		tags="@regression"
)
public class TestRunner {

}
