package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class BrowserActionsSteps {
    private WebDriver driver;
    private static final String W3SCHOOLS_URL = "https://www.w3schools.com";
    private static final String HTML_PAGE_URL = "https://www.w3schools.com/html/";

    // Initialize WebDriver before each scenario
    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("dom.webnotifications.enabled", false);
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
    }

    // Close WebDriver after each scenario
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I am on the W3Schools homepage")
    public void i_am_on_the_w3schools_homepage() {
        driver.get(W3SCHOOLS_URL);
    }

    @When("I refresh the page")
    public void i_refresh_the_page() {
        driver.navigate().refresh();
    }

    @Then("I should see the page reloaded successfully")
    public void i_should_see_the_page_reloaded_successfully() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i.fa.fa-logo.ws-hover-text-green")));
        Assert.assertTrue("The W3Schools logo should be visible after refresh.", logo.isDisplayed());
    }

    @Given("I am on a different page")
    public void i_am_on_a_different_page() {
        driver.get(HTML_PAGE_URL);
    }

    @When("I navigate back")
    public void i_navigate_back() {
        driver.navigate().back();
    }

    @Then("I should see the W3Schools homepage")
    public void i_should_see_the_w3schools_homepage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i.fa.fa-logo.ws-hover-text-green")));
        Assert.assertTrue("The W3Schools homepage should be loaded after navigating back.", logo.isDisplayed());
    }

    @When("I maximize the window")
    public void i_maximize_the_window() {
        driver.manage().window().maximize();
    }

    @Then("the browser window should be maximized")
    public void the_browser_window_should_be_maximized() {
        Dimension size = driver.manage().window().getSize();
        Assert.assertTrue("The window should be maximized.", size.getWidth() > 1000 && size.getHeight() > 700);
    }

    @When("I minimize the window")
    public void i_minimize_the_window() {
        driver.manage().window().setSize(new Dimension(800, 600));
    }

    @Then("the browser window should be minimized")
    public void the_browser_window_should_be_minimized() {
        Dimension size = driver.manage().window().getSize();
        Assert.assertTrue("The window should be minimized to 800x600.", size.equals(new Dimension(800, 600)));
    }
}
