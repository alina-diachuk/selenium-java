package com.procamp;

import com.procamp.litecart.pages.AdminPanelPage;
import com.procamp.litecart.pages.LoginPage;
import com.procamp.litecart.pages.ShopPage;
import com.procamp.litecart.utils.Listener;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected LoginPage loginPage;
    protected AdminPanelPage adminPanelPage;
    protected ShopPage shopPage;
    EventFiringWebDriver ewd;
    static WebDriver wd;

    public static final String USERNAME = "alinadiachuk1";
    public static final String AUTOMATE_KEY = "QfTAndQxZANsWWpYsH7z";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    protected abstract String getUrl();


    @Before
    public void setUp() throws MalformedURLException {
     //   WebDriverManager.chromedriver().setup();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "62.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("name", "Bstack-[Java] Sample Test");

        ewd = new EventFiringWebDriver(new RemoteWebDriver(new URL(URL), caps));
        ewd.register(new Listener());

        ewd.manage().window().setSize(new Dimension(1800, 800));

        ewd.get(getUrl());
        ewd.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        ewd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        loginPage = new LoginPage(ewd);
        adminPanelPage = new AdminPanelPage(ewd);
        shopPage = new ShopPage(ewd);
    }

    @After
    public void tearDown() {
        ewd.manage().deleteAllCookies();
        ewd.quit();
    }
}
