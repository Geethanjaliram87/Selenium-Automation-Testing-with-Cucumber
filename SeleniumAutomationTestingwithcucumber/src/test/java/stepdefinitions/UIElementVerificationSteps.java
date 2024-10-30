package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert; // Import for JUnit assertions
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UIElementVerificationSteps {
    private WebDriver driver;

    @Given("I am on the W3Schools Home page for UI verification")
    public void i_am_on_the_w3schools_home_page_UI() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("dom.webnotifications.enabled", false); // Example of setting preferences
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize(); // Maximize the window for better visibility
        driver.get("https://www.w3schools.com");
    }

    @Then("I should see the {string} link")
    public void i_should_see_the_link(String linkText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)));
        Assert.assertTrue("Link '" + linkText + "' should be visible.", link.isDisplayed());
    }

    @Then("I should see the {string} input field enabled")
    public void i_should_see_the_input_field_enabled(String fieldId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(fieldId)));
        Assert.assertTrue("The " + fieldId + " input field should be enabled.", inputField.isEnabled());
    }

     @Then("I should see the W3Schools logo image")
     public void i_should_see_the_w3schools_logo() {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         // Locate the icon using its class
         WebElement logoIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i.fa.fa-logo.ws-hover-text-green")));
         Assert.assertTrue("The W3Schools logo icon should be visible.", logoIcon.isDisplayed());
     }

    
    @Then("I should see the {string} button enabled")
    public void i_should_see_the_button_enabled(String buttonText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(buttonText)));
        Assert.assertTrue("The " + buttonText + " button should be enabled.", button.isEnabled());
    }
   

    // Clean up the driver after tests
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
