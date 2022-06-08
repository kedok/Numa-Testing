package es.stratio.numatesting.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BrowserDriverChrome {

    static ChromeDriver chromeDriver;


    public static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
        //chromeDriver.get("https://www.google.com");


        return chromeDriver;
    }
}
