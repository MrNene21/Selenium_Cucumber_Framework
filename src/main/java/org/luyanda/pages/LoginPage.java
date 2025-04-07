package org.luyanda.pages;

import org.luyanda.base.PageInteractions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends PageInteractions {

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Elements
    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginBtn;


    //Actions
    public void enterUsername(String usernameText){
        enterText(username,"username", usernameText);
    }

    public void enterPassword(String passwordText){
        enterText(password,"password", passwordText);
    }

    public void clickLoginBtn(){
        clickElement(loginBtn, "login");
    }
}
