package es.stratio.numatesting.steps;

import es.stratio.numatesting.browsers.BrowserDriverChrome;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StratioSteps {

    WebDriver webDriver = BrowserDriverChrome.getChromeDriver();
    @Given("google iniciado")
    public void googleIniciado() {
        webDriver.get("https://www.google.es/");

    }

    @And("cookies aceptadas")
    public void cookiesAceptadas() {
        webDriver.findElement(By.xpath("//div[text()='Acepto']/ancestor::button")).click();

        WebElement search_bar_element = this.webDriver.findElement(By.name("q"));
        search_bar_element.sendKeys("Stratio");
        search_bar_element.sendKeys(Keys.ENTER);


    }
}
