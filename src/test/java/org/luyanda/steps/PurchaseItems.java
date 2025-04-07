package org.luyanda.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.luyanda.base.TestContext;
import org.luyanda.managers.PageObjectManager;
import org.luyanda.pages.ProductsPage;

public class PurchaseItems {

    private TestContext testContext;
    private ProductsPage productsPage;

    public PurchaseItems(TestContext testContext){
        this.testContext = testContext;
        this.productsPage = new PageObjectManager(testContext.getDriver()).getProductPage();
    }

    @When("I add the item {string} to my shopping cart")
    public void i_add_the_item_to_my_shopping_cart(String itemName) {
        productsPage.selectItem(itemName);
    }

    @And("I click the shopping cart icon")
    public void i_click_the_shopping_cart_icon() throws InterruptedException {
        productsPage.openCart();
    }

}
