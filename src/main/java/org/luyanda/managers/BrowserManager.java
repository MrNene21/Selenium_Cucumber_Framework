package org.luyanda.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class BrowserManager {

    private static final String DEFAULT_BROWSER = "chrome";

    public static WebDriver createDriver(String browserType, boolean isHeadless) {

        WebDriver driver;

        System.out.println("Creating WebDriver for browser: " + browserType);


        if (browserType.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            if (isHeadless) {
                chromeOptions.addArguments("--headless"); // Enable headless mode
                chromeOptions.addArguments("--disable-gpu", "--window-size=1920,1080");
            } else {
                chromeOptions.addArguments("--start-maximized");
            }
            driver = new ChromeDriver(chromeOptions);
        } else if (browserType.equalsIgnoreCase("edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            if (isHeadless) {
                edgeOptions.addArguments("--headless"); // Enable headless mode
                edgeOptions.addArguments("--disable-gpu", "--window-size=1920,1080");
            } else {
                edgeOptions.addArguments("--start-maximized");
            }
            edgeOptions.addArguments("--start-maximized");
            driver = new EdgeDriver(edgeOptions);

        } else {
            throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));

        // Store driver in DriverManager for thread safety
        DriverManager.setDriver(driver);
        return driver;
    }

}
