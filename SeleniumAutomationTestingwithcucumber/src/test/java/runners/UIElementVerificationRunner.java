package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/UIElementVerification.feature", // Path to the feature files
    glue = {"stepdefinitions"},               // Package with step definition classes
    plugin = {"pretty",                        // To format the console output
              "html:target/ UIElementVerification cucumber-reports.html", // Generate an HTML report
              "json:target/cucumber-reports/Cucumber.json"} // JSON report
   // monochrome = true,                         // Makes console output more readable
   // tags = "@UIElementVerification"            // Runs scenarios tagged with @UIElementVerification
)
public class UIElementVerificationRunner {
    // No additional code needed; the @RunWith and @CucumberOptions annotations handle everything
}
