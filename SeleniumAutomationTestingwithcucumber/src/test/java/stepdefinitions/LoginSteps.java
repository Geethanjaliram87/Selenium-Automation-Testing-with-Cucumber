package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert;

public class LoginSteps {
    WebDriver driver;

    @Given("I open the login page")
    public void i_open_the_login_page() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/login");
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys("tomsmith");
        passwordField.sendKeys("SuperSecretPassword!");
    }

    @When("I enter invalid credentials")
    public void i_enter_invalid_credentials() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys("invalidUsername");
        passwordField.sendKeys("invalidPassword");
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }

    @Then("I should be redirected to the secure area")
    public void i_should_be_redirected_to_the_secure_area() {
        String expectedUrl = "http://the-internet.herokuapp.com/secure";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
        WebElement successMessage = driver.findElement(By.cssSelector(".flash.success"));
        Assert.assertTrue(successMessage.isDisplayed());
        driver.quit();
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        WebElement errorMessage = driver.findElement(By.cssSelector(".flash.error"));
        Assert.assertTrue(errorMessage.isDisplayed());
        driver.quit();
    }
}
