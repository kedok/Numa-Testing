package es.stratio.numatesting.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getTitle() {
        return this.webDriver.getTitle();
    }

    public String getUrl() {
        return this.webDriver.getCurrentUrl();
    }

    public String getLink(By link) {
        return this.webDriver.findElement(link).getAttribute("href");
    }
}
