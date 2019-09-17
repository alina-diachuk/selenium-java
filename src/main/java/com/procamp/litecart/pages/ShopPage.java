package com.procamp.litecart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ShopPage extends BasePage {

    @FindBy(xpath = "//h2[@class='title' and contains(text(),\"Latest Products\")]")
    private WebElement latestProductsSection;

    @FindBy(xpath = "//section[@id='box-popular-products']/div[@class='listing products']")
    private List<WebElement> popularProductsItem;

    @FindBy(xpath = "//button[@name='add_cart_product']")
    private WebElement btnAddToCart;

    @FindBy(xpath = "//div[@class='form-group required']/label[text()='Size']")
    private WebElement labelFormRequired;

    @FindBy(xpath = "//select[@class='form-control']")
    private Select drpDuckSize;

    @FindBy(xpath = "//div[@id='cart']//div[@class='badge quantity']")
    private WebElement btnCart;

    @FindBy(xpath = "//button[@class='btn btn-danger']")
    private WebElement btnRemoveFromCart;

    @FindBy(xpath = "//h2[@class='title' and contains(text(),\"Shopping Cart\")]")
    private WebElement shoppingCartSection;


    public ShopPage(EventFiringWebDriver ewd) {
        super(ewd);
    }

    public void tapOnProduct() {
        scrollToElement(latestProductsSection);
        int basicCount = popularProductsItem.size();
        for (int j = 0; j < basicCount; j++) {
            String format = String.format("//section[@id='box-popular-products']/div[@class='listing products']/article[%s]", j + 1);
            WebElement element = ewd.findElement(By.xpath(format));
            waitElementToClick(element);
            element.click();
            waitForPageLoad();
        }
    }

//    public void setBtnAddToCart() {
//        scrollToElement(btnAddToCart);
//        WebElement selectLabel = ewd.findElement(By.xpath("//div[@class='form-group required']/label[text()='Size']"));
//        if (!isElementPresent(selectLabel)) {
//            btnAddToCart.click();
//        } else {
//            drpDuckSize.selectByVisibleText("Small");
//            btnAddToCart.click();
//        }
//    }

    public void setBtnAddToCart() {
        scrollToElement(btnAddToCart);
        btnAddToCart.click();
    }

    public void openCart() {
        scrollUp();
        waitElementToClick(btnCart);
        tapOnElement(btnCart);
        waitForPageLoad();
    }

    public void removeProductFromCart() {
        waitElementToClick(btnRemoveFromCart);
        btnRemoveFromCart.click();
        waitForPageLoad();
    }

    public boolean shoppingCartDisplayed() {
        WebElement element = ewd.findElement(By.xpath("//h2[@class='title' and contains(text(),\"Shopping Cart\")]"));
        return !isElementPresent(element);
    }
}
