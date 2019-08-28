package com.procamp;

import org.junit.Test;


public class AdminFunctionalityTest extends BaseTest {

    @Test
    public void loginWithAlreadyEnteredCreds() {
        loginPage.clickLoginBtn();
        adminPanelPage.openListOfMenuItems();
    }

}
