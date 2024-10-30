package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/form_submission.feature", // Path to feature file
    glue = {"stepdefinitions"}, // Package containing step definitions
    plugin = {"pretty", "html:target/Form Submission cucumber-reports.html"} // Reporting options
)
public class FormSubmissionRunner {
}
