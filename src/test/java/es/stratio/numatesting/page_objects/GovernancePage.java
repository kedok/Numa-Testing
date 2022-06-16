package es.stratio.numatesting.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class GovernancePage extends BasePage {

    private final FluentWait wait = new FluentWait(webDriver);
    private By first_use_case = By.xpath("//section[3]/div/a");

    public GovernancePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void click_first_use_case() {
        this.webDriver.findElement(first_use_case).click();
        wait.until(ExpectedConditions.titleIs("Stratio :: Real-time replica of Core banking data with business meaning, QR and governance"));

    }
}
