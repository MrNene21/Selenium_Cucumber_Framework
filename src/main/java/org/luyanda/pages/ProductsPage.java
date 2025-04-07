package org.luyanda.pages;

import org.luyanda.base.PageInteractions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage extends PageInteractions {

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement shoppingCartIcon;

    @FindBy(xpath = "//div[@class='inventory_item_name ']")
    private List<WebElement> itemNames;

    @FindBy(xpath = "//button[text()='Add to cart']")
    private List<WebElement> addToCartButtons;


    public void selectItem(String itemName) {
        for (int i = 0; i < itemNames.size(); i++) {
            if (readText(itemNames.get(i)).equalsIgnoreCase(itemName)) {
                clickElement(addToCartButtons.get(i), "Add to cart");
                break;
            }
        }
    }

    // Example: Click the cart icon to go to the cart page
    public void openCart() {
        clickElement(shoppingCartIcon, "shopping cart");
    }
}
