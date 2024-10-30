package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.time.Duration;

public class FormSubmissionSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("I open the form submission page")
    public void i_open_the_form_submission_page() {
        driver.get("http://the-internet.herokuapp.com/login");
    }

    @When("I fill in the form with username {string} and password {string}")
    public void i_fill_in_the_form_with_username_and_password(String username, String password) {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @When("I click the submit button")
    public void i_click_the_submit_button() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        loginButton.click();
    }

    @Then("I should see {string}")
    public void i_should_see(String message) {
        if (message.equals("You have logged in!")) {
            String expectedUrl = "http://the-internet.herokuapp.com/secure";
            wait.until(ExpectedConditions.urlToBe(expectedUrl));
            Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".flash.success")));
            Assert.assertTrue("Success message is not displayed", successMessage.isDisplayed());
        } else {
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".flash.error")));
            Assert.assertTrue("Error message is not displayed", errorMessage.isDisplayed());
            Assert.assertTrue("Expected error message not found.", errorMessage.getText().contains(message));
        }
    }

    @After
    public void tearDown() {
        System.out.println("Tearing down the WebDriver...");
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed.");
        } else {
            System.out.println("Driver was null, nothing to close.");
        }
    }

}
