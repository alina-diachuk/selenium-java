package com.procamp.litecart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Optional;

public class ShopPage extends BasePage {

    @FindBy(xpath = "//h2[@class='title' and contains(text(),\"Latest Products\")]")
    private WebElement latestProductsSection;

    @FindBy(xpath = "//section[@id='box-popular-products']/div[@class='listing products']")
    private List<WebElement> popularProductsItem;

    @FindBy(xpath = "//button[@name='add_cart_product' and @type='submit']")
    private WebElement btnAddToCart;

    @FindBy(xpath = "//div[@class='badge quantity']")
    private WebElement badgeQuantity;

    @FindBy(xpath = "//select[@class='form-control']")
    private Select drpDuckSize;

    @FindBy(xpath = "//div[@id='cart']//div[@class='badge quantity']")
    private WebElement btnCart;

    @FindBy(xpath = "//button[@type='submit']/i[@class='fa fa-trash']")
    private WebElement btnRemoveFromCart;

    @FindBy(xpath = "//div[@class='cart wrapper']/p/a")
    private WebElement btnBack;


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

    public void setBtnAddToCart() {
        scrollToElement(btnAddToCart);
        if (drpDuckSize != null) {
            drpDuckSize.selectByVisibleText("Small");
        } else {
            btnAddToCart.click();
        }
        scrollUp();
    }


    public void openCart() {
        waitElementToClick(btnCart);
        tapOnElement(btnCart);
        waitForPageLoad();
    }

    public void removeProductFromCart() {
        waitElementToClick(btnRemoveFromCart);
        JavascriptExecutor executor = ewd;
        executor.executeScript("arguments[0].click();", btnRemoveFromCart);
        waitForPageLoad();
    }

    public int getCartItemCount() {
        waitElementToClick(badgeQuantity);
        String quantityParam = badgeQuantity.getAttribute("textContent");
        int quantity = Optional.ofNullable(quantityParam).filter(s -> s != null && !s.isEmpty())
                .map(Integer::parseInt)
                .orElse(0);
        return quantity;
    }

    public void returnHome() {
        waitElementToClick(btnBack);
        btnBack.click();
        waitForPageLoad();
    }

    public boolean isBadgeExists() {
        waitForPageLoad();
        String quantityParam = badgeQuantity.getAttribute("textContent");
        return quantityParam == null|| quantityParam.isEmpty();

    }
}
