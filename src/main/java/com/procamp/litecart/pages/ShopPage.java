package com.procamp.litecart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ShopPage extends BasePage {

    @FindBy(xpath = "//h2[@class='title' and contains(text(),\"Popular Products\")]")
    private WebElement popularProductsSection;

    @FindBy(xpath = "//section[@id='box-popular-products']/div[@class='listing products']")
    private List<WebElement> popularProductsItem;

    @FindBy(xpath = "//button[@name='add_cart_product']")
    private WebElement btnAddToCart;

    @FindBy(xpath = "//div[@class='form-group required']/label[text()='Size']")
    private WebElement labelFormRequired;

    @FindBy(xpath = "//select[@class='form-control']")
    private Select drpDuckSize;

    @FindBy(xpath = "//button[@class='btn btn-danger']")
    private WebElement btnRemoveFromCart;


    public ShopPage(EventFiringWebDriver ewd) {
        super(ewd);
    }

    public void tapOnProduct() {
        scrollToElement(popularProductsSection);
        int basicCount = popularProductsItem.size();
        for (int j = 0; j < basicCount; j++) {
            String format = String.format("//section[@id='box-popular-products']/div[@class='listing products']/article[%s]", j + 1);
            WebElement element = ewd.findElement(By.xpath(format));
            element.click();
            waitForPageLoad();
        }
    }

    public void chooseDuckSize() {
        scrollToElement(labelFormRequired);
        drpDuckSize.selectByVisibleText("Small");

    }

    public void setBtnAddToCart() {
        scrollToElement(btnAddToCart);
        btnAddToCart.click();
        waitForPageLoad();

    }

    public void removeProductFromCart() {
        waitElementToClick(btnRemoveFromCart);
        waitForPageLoad();

    }
}
