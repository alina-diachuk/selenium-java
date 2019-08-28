package com.procamp;

import com.procamp.litecart.pages.AdminPanelPage;
import com.procamp.litecart.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver wd;
    protected LoginPage loginPage;
    protected AdminPanelPage adminPanelPage;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        wd.manage().window().maximize();

        wd.get("http://demo.litecart.net/admin/");
        wd.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        loginPage = new LoginPage(wd);
        adminPanelPage = new AdminPanelPage(wd);

    }

    @After
    public void tearDown() {
        wd.quit();
    }
}
