package org.luyanda.pages;

import org.luyanda.base.PageInteractions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends PageInteractions {

    public CartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //Elements
    @FindBy(xpath = "//span[.='Your Cart']")
    private WebElement yourCartText;

    @FindBy(xpath = "//button[.='Remove']")
    private WebElement removeBtn;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;
}
