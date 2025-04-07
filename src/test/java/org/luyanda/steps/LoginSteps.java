package org.luyanda.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.luyanda.base.TestContext;
import org.luyanda.managers.PageObjectManager;
import org.luyanda.pages.HomePage;
import org.luyanda.pages.LoginPage;
import org.luyanda.utilities.PropertyReaderUtil;
import org.testng.Assert;

public class LoginSteps {

    private TestContext testContext;
    private LoginPage loginPage;
    private HomePage homePage;
    private PageObjectManager pageObjectManager;

    public LoginSteps(TestContext testContext) {
        this.testContext = testContext;
        this.pageObjectManager = testContext.getPageObjectManager();
        this.loginPage = pageObjectManager.getLoginPage();
        this.homePage = pageObjectManager.getHomePage();
    }

    @Given("I navigate to the sauce demo web application")
    public void iNavigateToTheSauceDemoWebApplication() {
        testContext.navigateToURL();
    }

    @When("I enter valid credentials")
    public void iEnterValidCredentials() {
        loginPage.enterUsername(PropertyReaderUtil.getProperty("username"));
        loginPage.enterPassword(PropertyReaderUtil.getProperty("password"));
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginBtn();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() throws InterruptedException {
        Assert.assertTrue(homePage.isProductsTitleVisible(), "Login failed!");
    }

}
