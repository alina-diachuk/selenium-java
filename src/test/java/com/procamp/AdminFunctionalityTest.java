package com.procamp;

import com.procamp.litecart.utils.Constants;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;


public class AdminFunctionalityTest extends BaseTest {

    @Override
    protected String getUrl() {
        return Constants.ADMIN_PANEL_URL;
    }

    @Test
    public void loginWithAlreadyEnteredCreds() {
        loginPage.clickLoginBtn();
        assertTrue(adminPanelPage.logoIsDisplayed());
        adminPanelPage.openListOfMenuItems();
    }



}



