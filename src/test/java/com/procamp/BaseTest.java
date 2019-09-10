package com.procamp;

import com.procamp.litecart.pages.AdminPanelPage;
import com.procamp.litecart.pages.LoginPage;
import com.procamp.litecart.utils.Listener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected LoginPage loginPage;
    protected AdminPanelPage adminPanelPage;
    EventFiringWebDriver ewd;

    protected abstract String getUrl();


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ewd = new EventFiringWebDriver(new ChromeDriver());
        ewd.register(new Listener());

        ewd.manage().window().maximize();

        ewd.get(getUrl());
        ewd.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        ewd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        loginPage = new LoginPage(ewd);
        adminPanelPage = new AdminPanelPage(ewd);

    }

    @After
    public void tearDown() {
        ewd.manage().deleteAllCookies();
        ewd.quit();
    }
}
