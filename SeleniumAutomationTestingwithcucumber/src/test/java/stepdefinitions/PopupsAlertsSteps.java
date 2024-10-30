package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopupsAlertsSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println("Error during tear down: " + e.getMessage());
        }
    }

    @Given("the user is on the JavaScript alerts page")
    public void navigateToJavaScriptAlertsPage() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    }

    @When("the user triggers a simple alert pop-up")
    public void triggerSimpleAlertPopup() {
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
    }

    @When("the user triggers a confirmation pop-up")
    public void triggerConfirmationPopup() {
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
    }

    @When("the user triggers a prompt pop-up")
    public void triggerPromptPopup() {
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
    }

    @Then("the user accepts the alert")
    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Then("the user dismisses the confirmation")
    public void dismissConfirmation() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    @Then("the user enters {string} in the prompt")
    public void enterTextInPrompt(String inputText) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(inputText);
        alert.accept();
    }

    @Then("the page should show a success message for the alert")
    public void verifyAlertSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        String resultText = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("Alert success message mismatch", "You successfully clicked an alert", resultText);
    }

    @Then("the page should show a cancel message for the confirmation")
    public void verifyCancelMessageForConfirmation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        String resultText = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("Confirmation cancel message mismatch", "You clicked: Cancel", resultText);
    }

    @Then("the page should display the entered text in the result message {string}")
    public void verifyEnteredTextInResult(String expectedText) {
        String resultText = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You entered: " + expectedText, resultText);
    }

}
