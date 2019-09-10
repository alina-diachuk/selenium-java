package com.procamp.litecart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ShopPage extends BasePage {

    @FindBy(xpath = "//div[@class='listing products']//div[@class='image-wrapper']")
    private WebElement productItem;

    public ShopPage(EventFiringWebDriver ewd) {
        super(ewd);
    }
}
