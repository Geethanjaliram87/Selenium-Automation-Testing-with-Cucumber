package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/login.feature", // Path to your feature files
    glue = {"stepdefinitions"},               // Package name where step definitions are located
    plugin = {"pretty", "html:target/Login cucumber-reports.html"} // Generates a report in HTML format
   // monochrome = true,                        // Display the console output in a readable format
     //tags = "@login"                           // Optional: specify tags to run specific tests
)
public class LoginTestRunner {
    // This class will be empty, used only as an entry point for JUnit to run the Cucumber tests
}
