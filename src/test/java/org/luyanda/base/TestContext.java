package org.luyanda.base;

import org.luyanda.managers.BrowserManager;
import org.luyanda.managers.DriverManager;
import org.luyanda.managers.PageObjectManager;
import org.luyanda.utilities.PropertyReaderUtil;
import org.openqa.selenium.WebDriver;

public class TestContext {

    private final String browserType;
    private final boolean isHeadless;
    private PageObjectManager pageObjectManager;


    public TestContext(){
        // Fetch the browser type from the properties file
        this.browserType = PropertyReaderUtil.getProperty("browser"); // Fetch from properties file

        // Fetch headless mode property from system or properties file
        String headlessProperty = System.getProperty("headless");
        isHeadless = headlessProperty != null ? Boolean.parseBoolean(headlessProperty) : Boolean.parseBoolean(PropertyReaderUtil.getProperty("headless"));
    }


    public void initializeDriver() {
        // Use BrowserManager to create the WebDriver and set it in DriverManager
        DriverManager.setDriver(BrowserManager.createDriver(browserType, isHeadless));
    }

    public void cleanupDriver() {
        // Use DriverManager to safely quit the WebDriver
        DriverManager.quitDriver();
    }

    public WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    public void navigateToURL() {
        String url = PropertyReaderUtil.getProperty("url");
        if (url.isEmpty()) {
            throw new IllegalStateException("Application URL is not specified in the properties file.");
        }
        getDriver().get(url);
    }

    public PageObjectManager getPageObjectManager() {
        if (pageObjectManager == null) {
            pageObjectManager = new PageObjectManager(getDriver());
        }
        return pageObjectManager;
    }

}
