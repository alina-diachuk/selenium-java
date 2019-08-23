package com.procamp;

import org.junit.Test;


public class LoginFunctionalityTest extends BaseTest {

    @Test
    public void loginWithAlreadyEnteredCreds() {
        loginBO.checkLogin();
    }
}
