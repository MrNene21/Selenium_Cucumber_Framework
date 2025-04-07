package org.luyanda.managers;

import org.luyanda.pages.HomePage;
import org.luyanda.pages.LoginPage;
import org.luyanda.pages.ProductsPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private ProductsPage productsPage;


    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public ProductsPage getProductPage() {
        return (productsPage == null) ? productsPage = new ProductsPage(driver) : productsPage;
    }
}
