package com.procamp.litecart.bo;

import com.procamp.litecart.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginBO extends LoginPage {

    public LoginBO(WebDriver wd) {
        super(wd);
    }

    public void checkLogin() {
        clickLoginBtn();
    }
}
