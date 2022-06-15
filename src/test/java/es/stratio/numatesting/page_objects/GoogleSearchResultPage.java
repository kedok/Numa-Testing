package es.stratio.numatesting.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class GoogleSearchResultPage extends BasePage {

    private final By stratio_first_link = By.xpath("//h3/ancestor::a");
    private final FluentWait wait = new FluentWait(webDriver);
    private JavascriptExecutor js = (JavascriptExecutor) webDriver;

    public GoogleSearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void click_on_first_result() {
        wait.withTimeout(Duration.ofMillis(10000));
        wait.pollingEvery(Duration.ofMillis(250));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(stratio_first_link));
        WebElement webElement = webDriver.findElement(stratio_first_link);
        js.executeScript("arguments[0].click();", webElement);

    }


    public By getStratio_first_link() {
        return stratio_first_link;
    }
}
