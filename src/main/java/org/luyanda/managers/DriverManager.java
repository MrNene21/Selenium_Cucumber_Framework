package org.luyanda.managers;

import org.luyanda.utilities.LoggerUtil;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            LoggerUtil.warn("Driver not initialized in ThreadLocal.");
            throw new IllegalStateException("WebDriver is not initialized for the current thread.");
        }
        return driverThreadLocal.get();
    }

    public static void setDriver(WebDriver driver) {
        if (driver == null) {
            throw new IllegalStateException("Attempting to set a null WebDriver instance.");
        }
        driverThreadLocal.set(driver);
    }

    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }

}
