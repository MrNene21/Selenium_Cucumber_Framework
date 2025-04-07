package org.luyanda.steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.luyanda.base.TestContext;
import org.luyanda.managers.DriverManager;
import org.luyanda.utilities.ScreenshotUtil;

public class Hooks {

    private final TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before()
    public void setupDriver() {
        testContext.initializeDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        scenario.attach(ScreenshotUtil.takeScreenshot(testContext.getDriver()),"image/png", scenario.getName());
        scenario.log("Current Url: " + DriverManager.getDriver().getCurrentUrl());
        testContext.cleanupDriver();
    }

}
