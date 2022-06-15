package es.stratio.numatesting.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage extends BasePage {

    By button_accept_cookies_google = By.xpath("//div[text()='Acepto']/ancestor::button");

    public GooglePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage(String page) {
        this.webDriver.get(page);
    }

    public void search(String text) {
        WebElement search_bar_element = this.webDriver.findElement(By.name("q"));
        search_bar_element.sendKeys(text);
        search_bar_element.sendKeys(Keys.ENTER);
    }

    public void accept_cookies() {
        this.webDriver.findElement(button_accept_cookies_google).click();
    }

}
