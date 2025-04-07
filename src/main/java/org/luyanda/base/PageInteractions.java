package org.luyanda.base;

import org.luyanda.managers.DriverManager;
import org.luyanda.utilities.LoggerUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageInteractions {

    public WebDriver driver;
    WebDriverWait wait;

    // Constructor that accepts WebDriver as a parameter
    public PageInteractions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    protected void clickElement(WebElement element, String nameOfElement) {
        try {
            if (waitForElement(element)) {
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                LoggerUtil.info(nameOfElement + " button has been clicked.");
            }
        } catch (StaleElementReferenceException e) {
            LoggerUtil.warn(nameOfElement + " is stale, attempting to click using JavaScript...");
            try {
                JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
                js.executeScript("arguments[0].click();", element);
                LoggerUtil.info(nameOfElement + " button clicked successfully via JavaScript.");
            } catch (Exception jsException) {
                LoggerUtil.error("JavaScript click failed for " + nameOfElement + ": " + jsException.getMessage());
            }
        } catch (TimeoutException e) {
            LoggerUtil.error(nameOfElement + " did not become clickable within the timeout: " + e.getMessage());
        }
    }

    protected void enterText(WebElement element, String nameOfElement, String inputText){
            if (waitForElement(element)){
                element.clear();
                element.sendKeys(inputText);
                LoggerUtil.info("The text " + "'" + inputText + "' "+ "was sent to " + nameOfElement + " field");
            }
            else{
                LoggerUtil.error(inputText + " text could not be  sent to " + nameOfElement + " field because it cannot be found!");
            }
    }

    protected Boolean waitForElement(WebElement element){
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }
        catch (TimeoutException | NoSuchElementException e) {
            LoggerUtil.info("Element could not be found or did not become visible within the time limit! " + e.getMessage());
            return false;
        }
    }

    protected String readText(WebElement element){
        if(waitForElement(element)){
            String text = element.getText();
            LoggerUtil.info("The text '" + text + "' was returned");
            return element.getText();
        }
        else{
            LoggerUtil.error("Could not read element text!");
            return null;
        }
    }
}
