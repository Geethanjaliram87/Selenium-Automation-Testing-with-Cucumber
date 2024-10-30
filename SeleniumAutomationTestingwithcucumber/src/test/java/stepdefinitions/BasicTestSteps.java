package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert;

public class BasicTestSteps {
    WebDriver driver; // Declare the WebDriver at the class level

    @Before
    public void setup() {
        WebDriverManager.firefoxdriver().setup(); // Set up geckodriver for Firefox
        driver = new FirefoxDriver(); // Initialize the FirefoxDriver
    }

    @Given("I open the browser")
    public void i_open_the_browser() {
        // The browser is already opened in the @Before setup method
    }

    @When("I go to {string}")
    public void i_go_to(String url) {
        driver.get(url); // Navigate to the specified URL
    }

    @Then("I should see the Google homepage")
    public void i_should_see_the_google_homepage() {
        String title = driver.getTitle(); // Get the page title
        Assert.assertEquals("Google", title); // Verify the title is "Google"
        driver.quit(); // Close the browser after verification
    }
}
