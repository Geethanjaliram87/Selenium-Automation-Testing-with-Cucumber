package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class NavigationTestingSteps {
    private WebDriver driver;
    private WebDriverWait wait;
    private String homePageTitle;
    private String learnHtmlPageTitle;

    @Given("I am on the W3Schools Home page")
    public void i_am_on_the_w3schools_home_page() {
        // Setup Firefox driver with WebDriverManager
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        
        // Set an explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        // Navigate to W3Schools homepage
        driver.get("https://www.w3schools.com");
        
        // Store the home page title
        homePageTitle = driver.getTitle();
        System.out.println("W3Schools Home Page Title: " + homePageTitle);
    }

    @When("I click on the {string} link")
    public void i_click_on_the_link(String linkText) throws InterruptedException {
        WebElement link = driver.findElement(By.linkText(linkText));
        link.click();
        
        // Wait for the page to load by adding a brief pause
        Thread.sleep(2000);
        
        // Capture the Learn HTML page title for validation
        learnHtmlPageTitle = driver.getTitle();
        System.out.println(linkText + " Page Title: " + learnHtmlPageTitle);
    }

    @Then("I should be on the {string} page")
    public void i_should_be_on_the_page(String expectedPage) {
        if (expectedPage.equals("Learn HTML")) {
            assertEquals("Expected to be on the Learn HTML page, but the title did not match.", learnHtmlPageTitle, driver.getTitle());
        } else {
            assertEquals("Expected to be on the Home page, but the title did not match.", homePageTitle, driver.getTitle());
        }
    }

    @When("I navigate back to the Home page")
    public void i_navigate_back_to_the_home_page() throws InterruptedException {
        driver.navigate().back();
        Thread.sleep(2000);  // Wait briefly for the page to load
    }

    @Then("I should be back on the Home page")
    public void i_should_be_back_on_the_home_page() {
        assertEquals("Expected to be on the Home page.", homePageTitle, driver.getTitle());
    }

    @When("I navigate forward to the {string} page")
    public void i_navigate_forward_to_the_page(String pageTitle) throws InterruptedException {
        driver.navigate().forward();
        Thread.sleep(2000);
        assertEquals("Expected to be on the " + pageTitle + " page.", learnHtmlPageTitle, driver.getTitle());
    }

    @Then("I should be on the {string} page again")
    public void i_should_be_on_the_page_again(String pageTitle) {
        assertEquals("Expected to be on the " + pageTitle + " page again.", learnHtmlPageTitle, driver.getTitle());
    }

    @io.cucumber.java.After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
