package es.stratio.numatesting.steps;

import es.stratio.numatesting.browsers.BrowserDriverChrome;
import es.stratio.numatesting.browsers.BrowserDriverFirefox;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StratioSteps {
    By button_accept_cookies_google = By.xpath("//div[text()='Acepto']/ancestor::button");
    By button_accept_cookies_stratio = By.xpath("//div[@class='controls']/button[1]");
    By stratio_first_link = By.xpath("//h3/ancestor::a");
    By dropdown_solutions_stratio = By.xpath("//div[text()=' Solutions']");
    By governance_dropdown = By.xpath("//div[text()=' By use case ']/ancestor::div[1]/div[4]");
    By first_use_case = By.xpath("//section[3]/div/a");
    By tittle_of_first_element_of_use_case = By.xpath("//main//h1");
//    WebDriver webDriver = BrowserDriverChrome.getChromeDriver();
    WebDriver webDriver = BrowserDriverFirefox.getFirefox();
    JavascriptExecutor js = (JavascriptExecutor)  webDriver;
    FluentWait wait = new FluentWait(webDriver);

    @Given("browser initiated")
    public void googleIniciado() {
        webDriver.get("https://www.google.es/");

    }

    @And("google cookies accepted")
    public void cookiesAceptadas() {
        webDriver.findElement(button_accept_cookies_google).click();


    }

    @When("user types Stratio in search bar and press enter")
    public void userTypesStratioInSearchBarAndPressEnter() {
        WebElement search_bar_element = this.webDriver.findElement(By.name("q"));
        search_bar_element.sendKeys("Stratio");
        search_bar_element.sendKeys(Keys.ENTER);
    }

    @Then("shows all results of Stratio")
    public void showsAllResultsOfStratio() {
        wait.withTimeout(Duration.ofMillis(10000));
        wait.pollingEvery(Duration.ofMillis(250));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(stratio_first_link));
        assertEquals("https://www.stratio.com/", webDriver.findElement(stratio_first_link).getAttribute("href"));
    }


    @When("user click first link")
    public void userClickFirstLink() {
//        Actions actions = new Actions(webDriver);
        WebElement webElement = webDriver.findElement(stratio_first_link);
//        actions.moveToElement(webElement).click().perform();

        js.executeScript("arguments[0].click();",webElement);


//        webDriver.findElement(stratio_first_link).click();
    }

    @And("accept stratio cookies")
    public void acceptStratioCookies() throws InterruptedException {

//        Thread.sleep(10000);
        wait.withTimeout(Duration.ofMillis(10000));
        wait.pollingEvery(Duration.ofMillis(250));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(button_accept_cookies_stratio));
        WebElement webElement = webDriver.findElement(button_accept_cookies_stratio);
        js.executeScript("arguments[0].click();",webElement);
//        webDriver.findElement(button_accept_cookies_stratio).click();
    }

    @Then("show Stratio Home page")
    public void showStratioHomePage() {
        assertEquals("Stratio ::Transform and build your digital strategy around Big Data and AI", webDriver.getTitle());
    }


    @When("user click the dropdown Solutions")
    public void userClickTheDropdownSolutions() {
        webDriver.findElement(dropdown_solutions_stratio).click();
    }

    @And("user select Governance from the dropdown")
    public void userSelectGovernanceFromTheDropdown() {
        webDriver.findElement(governance_dropdown).click();
    }

    @Then("Governance page loads")
    public void governancePageLoads() {

        wait.withTimeout(Duration.ofMillis(5000));
        wait.pollingEvery(Duration.ofMillis(250));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.titleIs("Stratio :: Data reliability is the base of successful companies"));


        assertEquals("https://www.stratio.com/solutions/by-use-case/governance", webDriver.getCurrentUrl());
    }

    @And("print first case title")
    public void printFirstCaseTitle() {
        webDriver.findElement(first_use_case).click();
        wait.until(ExpectedConditions.titleIs("Stratio :: Real-time replica of Core banking data with business meaning, QR and governance"));
        System.out.println(webDriver.findElement(tittle_of_first_element_of_use_case).getAccessibleName());
    }


}
