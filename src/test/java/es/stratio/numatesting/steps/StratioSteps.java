package es.stratio.numatesting.steps;

import es.stratio.numatesting.browsers.BrowserDriverChrome;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StratioSteps {
    By button_accept_cookies_google = By.xpath("//div[text()='Acepto']/ancestor::button");
    By button_accept_cookies_stratio = By.xpath("//div[@class='controls']/button[1]");
    By stratio_first_link = By.xpath("//h3[text()='Stratio ::Transform and build your digital strategy around ...']/ancestor::a");
    By dropdown_solutions_stratio = By.xpath("//div[text()=' Solutions']");
    By governance_dropdown = By.xpath("//div[text()=' By use case ']/ancestor::div[1]/div[4]");
    By first_use_case = By.xpath("//section[3]/div/a");
    WebDriver webDriver = BrowserDriverChrome.getChromeDriver();
    @Given("google iniciado")
    public void googleIniciado() {
        webDriver.get("https://www.google.es/");

    }

    @And("cookies aceptadas")
    public void cookiesAceptadas() throws InterruptedException {
        webDriver.findElement(button_accept_cookies_google).click();
        WebElement search_bar_element = this.webDriver.findElement(By.name("q"));
        search_bar_element.sendKeys("Stratio");
        search_bar_element.sendKeys(Keys.ENTER);
        assertEquals("https://www.stratio.com/",webDriver.findElement(stratio_first_link).getAttribute("href"));
        webDriver.findElement(stratio_first_link).click();
        webDriver.findElement(button_accept_cookies_stratio).click();
        assertEquals("Stratio ::Transform and build your digital strategy around Big Data and AI",webDriver.getTitle());
        webDriver.findElement(dropdown_solutions_stratio).click();
        webDriver.findElement(governance_dropdown).click();

        FluentWait wait = new FluentWait(webDriver);
        wait.withTimeout(Duration.ofMillis(5000));
        wait.pollingEvery(Duration.ofMillis(250));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.titleIs("Stratio :: Data reliability is the base of successful companies"));


        assertEquals("https://www.stratio.com/solutions/by-use-case/governance",webDriver.getCurrentUrl());
        webDriver.findElement(first_use_case).click();

    }
}
