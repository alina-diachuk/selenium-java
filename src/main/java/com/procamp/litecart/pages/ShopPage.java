package com.procamp.litecart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage extends BasePage {

    @FindBy(xpath = "//div[@class='listing products']//div[@class='image-wrapper']")
    private WebElement productItem;

    public ShopPage(WebDriver wd) {
        super(wd);
    }
}
