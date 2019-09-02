package com.procamp;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;


public class AdminFunctionalityTest extends BaseTest {


        @Test
        public void loginWithAlreadyEnteredCreds() {
            loginPage.clickLoginBtn();
            assertTrue(adminPanelPage.logoIsDisplayed());
            adminPanelPage.openListOfMenuItems();
        }

    }



