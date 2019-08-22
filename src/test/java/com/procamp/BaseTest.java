package com.procamp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    private WebDriver wd;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        wd.manage().window().maximize();
    }

    @Test
    public void openSite() {
        wd.get("https://www.google.com");
    }

    @After
    public void tearDown() {
        wd.quit();
    }
}
