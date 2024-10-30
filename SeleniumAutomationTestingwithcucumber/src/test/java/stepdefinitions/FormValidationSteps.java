package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormValidationSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    @Given("the user is on the registration page")
    public void navigateToRegistrationPage() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Use Duration for wait time
        driver.get("http://practice.automationtesting.in/my-account/");
    }

    @When("the user enters invalid {string} and {string}")
    public void enterInvalidCredentials(String email, String password) {
        WebElement emailField = driver.findElement(By.id("reg_email"));
        WebElement passwordField = driver.findElement(By.id("reg_password"));

        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @When("clicks on the register button")
    public void clickRegisterButton() {
        driver.findElement(By.name("register")).click();
    }

    @Then("the system should display {string} validation message")
    public void verifyValidationMessage(String expectedMessage) {
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-error li")));
        String actualMessage = errorMessageElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
