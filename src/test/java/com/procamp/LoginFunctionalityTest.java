package com.procamp;

import com.procamp.litecart.pages.AdminPanelPage;
import org.junit.Test;


public class LoginFunctionalityTest extends BaseTest {

    @Test
    public void loginWithAlreadyEnteredCreds() {
        loginBO.checkLogin();
        new AdminPanelPage(wd).openListOfMenuItems();
    }

}
