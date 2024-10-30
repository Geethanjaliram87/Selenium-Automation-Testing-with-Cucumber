package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/navigation_testing.feature", // Path to the feature files
    glue = "stepdefinitions",                 // Path to the step definitions
    plugin = {"pretty", "html:target/Navication Testing cucumber-reports.html"} // Report generation
    //monochrome = true,                         // Makes console output more readable
   // tags = "@NavigationTesting"                // Optional: specify tag to run specific tests
)
public class NavigationTestingRunner {
}