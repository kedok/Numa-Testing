package es.stratio.numatesting.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserDriverFirefox {

    static WebDriver firefoxDriver;

    public static WebDriver getFirefox(){
        System.setProperty("webdriver.gecko.driver","./drivers/geckodriver");

        firefoxDriver = new FirefoxDriver();
        firefoxDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));

        return firefoxDriver;
    }
}
