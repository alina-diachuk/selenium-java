package com.procamp.litecart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = " ")
    private WebElement btnLogin;

    public LoginPage(WebDriver wd) {
        super(wd);
    }

    public void clickLoginBtn() {
        waitElementToClick(btnLogin);
        btnLogin.click();
        waitForPageLoad();

    }
}
