// TestRunner.java
package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/basicTest.feature",
        glue = "stepdefinitions",
        plugin = {"pretty", "html:target/Basic Test cucumber-reports.html"}
//        monochrome = true

)
public class TestRunner {
}
