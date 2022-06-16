package es.stratio.numatesting.steps;

import es.stratio.numatesting.browsers.BrowserDriverFirefox;
import es.stratio.numatesting.page_objects.GooglePage;
import es.stratio.numatesting.page_objects.GoogleSearchResultPage;
import es.stratio.numatesting.page_objects.GovernancePage;
import es.stratio.numatesting.page_objects.StratioPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StratioSteps {


    WebDriver webDriver = BrowserDriverFirefox.getFirefox();
    GooglePage googlePage = new GooglePage(webDriver);
    GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage(webDriver);
    StratioPage stratioPage = new StratioPage(webDriver);
    GovernancePage governancePage = new GovernancePage(webDriver);

    @Given("browser initiated")
    public void googleIniciado() {
        googlePage.openPage("https://www.google.es/");
    }

    @And("google cookies accepted")
    public void cookiesAceptadas() throws InterruptedException {
        Thread.sleep(1000);
        googlePage.accept_cookies();

    }

    @When("user types Stratio in search bar and press enter")
    public void userTypesStratioInSearchBarAndPressEnter() throws InterruptedException {
        Thread.sleep(1000);
        googlePage.search("Stratio");
    }

    @Then("shows all results of Stratio")
    public void showsAllResultsOfStratio() throws InterruptedException {
        Thread.sleep(1000);
        assertEquals("https://www.stratio.com/", googlePage.getLink(googleSearchResultPage.getStratio_first_link()));
    }


    @When("user click first link")
    public void userClickFirstLink() {
        googleSearchResultPage.click_on_first_result();
    }

    @And("accept stratio cookies")
    public void acceptStratioCookies() {
        stratioPage.accept_cookies();
    }

    @Then("show Stratio Home page")
    public void showStratioHomePage() {
        assertEquals("Stratio ::Transform and build your digital strategy around Big Data and AI", stratioPage.getTitle());
    }


    @When("user click the dropdown Solutions")
    public void userClickTheDropdownSolutions() throws InterruptedException {
        Thread.sleep(2000);
        stratioPage.dropdown_solutions();
    }

    @And("user select Governance from the dropdown")
    public void userSelectGovernanceFromTheDropdown() throws InterruptedException {
        Thread.sleep(2000);
        stratioPage.dropdown_solutions();
    }

    @Then("Governance page loads")
    public void governancePageLoads() throws InterruptedException {
        Thread.sleep(1500);
        stratioPage.governance_dropdown();
        Thread.sleep(1500);
        assertEquals("https://www.stratio.com/solutions/by-use-case/governance", stratioPage.getUrl());
    }

    @And("print first case title")
    public void printFirstCaseTitle() {
        governancePage.click_first_use_case();
        System.out.println(governancePage.getTitle());
    }


}
