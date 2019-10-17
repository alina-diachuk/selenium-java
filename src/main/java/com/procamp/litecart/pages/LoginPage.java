package com.procamp.litecart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//div[@class = 'footer']//button[@name = 'login']")
    private WebElement btnLogin;

    public LoginPage(EventFiringWebDriver ewd) {
        super(ewd);
    }

    public void clickLoginBtn() {
        waitElementToClick(btnLogin);
        btnLogin.click();
        waitForPageLoad();

    }
}
