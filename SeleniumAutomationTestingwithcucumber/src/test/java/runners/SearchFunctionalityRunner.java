package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/search_functionality.feature", // Path to your feature files
    glue = {"stepdefinitions"}, // Package name where step definitions are located
    		 plugin = {"pretty", "html:target/Search Functionality cucumber-reports.html"} // Reporting options
   // monochrome = true, // Better console output readability
  //  tags = "@search" // Optional: Run scenarios tagged with @search
)
public class SearchFunctionalityRunner {
    // This class remains empty and is used only as a runner for the feature files
}
