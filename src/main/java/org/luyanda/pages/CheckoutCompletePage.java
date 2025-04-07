package org.luyanda.pages;

import org.luyanda.base.PageInteractions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends PageInteractions {

    public CheckoutCompletePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[.='Checkout: Complete!']")
    private WebElement checkoutCompleteTitle;

    @FindBy(xpath = "//h2[.='Thank you for your order!']")
    private WebElement thankYouForOrderText;

    @FindBy(xpath = "//div[.='Your order has been dispatched, and will arrive just as fast as the pony can get there!']")
    private WebElement orderDispatchedText;
}
