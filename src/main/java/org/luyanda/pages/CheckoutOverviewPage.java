package org.luyanda.pages;

import org.luyanda.base.PageInteractions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage extends PageInteractions {

    public CheckoutOverviewPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[.='Checkout: Your Overview']")
    private WebElement checkoutOverViewTitle;

    @FindBy(id = "finish")
    private WebElement finishBtn;


}
