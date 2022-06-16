package es.stratio.numatesting.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class StratioPage extends BasePage {

    private final FluentWait wait = new FluentWait(webDriver);
    private By button_accept_cookies_stratio = By.xpath("//div[@class='controls']/button[1]");
    private By dropdown_solutions_stratio = By.xpath("//div[text()=' Solutions']");
    private By governance_dropdown = By.xpath("//div[text()=' By use case ']/ancestor::div[1]/div[4]");
    private JavascriptExecutor js = (JavascriptExecutor) webDriver;

    public StratioPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void accept_cookies() {
        wait.withTimeout(Duration.ofMillis(10000));
        wait.pollingEvery(Duration.ofMillis(250));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(button_accept_cookies_stratio));
        WebElement webElement = webDriver.findElement(button_accept_cookies_stratio);
        js.executeScript("arguments[0].click();", webElement);
    }

    public void dropdown_solutions() {
        wait.withTimeout(Duration.ofMillis(10000));
        wait.pollingEvery(Duration.ofMillis(250));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.titleIs("Stratio ::Transform and build your digital strategy around Big Data and AI"));
        WebElement webElement = webDriver.findElement(dropdown_solutions_stratio);
        js.executeScript("arguments[0].click();", webElement);
    }

    public void governance_dropdown() {
        wait.withTimeout(Duration.ofMillis(10000));
        wait.pollingEvery(Duration.ofMillis(250));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(governance_dropdown));
        WebElement webElement = webDriver.findElement(governance_dropdown);
        js.executeScript("arguments[0].click();", webElement);
    }
}
