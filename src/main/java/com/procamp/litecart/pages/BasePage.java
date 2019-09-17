package com.procamp.litecart.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    public EventFiringWebDriver ewd;


    public BasePage(EventFiringWebDriver ewd) {
        this.ewd = ewd;
        PageFactory.initElements(this.ewd, this);
    }

    public void waitElementToClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(ewd, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForPageLoad() {
        new WebDriverWait(ewd, 1000).until((ExpectedCondition<Boolean>) ewd ->
                ((JavascriptExecutor) ewd).executeScript("return document.readyState").equals("complete"));
    }

    public void scrollToElement(WebElement element) {
        Actions actions = new Actions(ewd);
        actions.moveToElement(element);
        actions.perform();
    }

    public void scrollUp() {
        JavascriptExecutor jse = ewd;
        jse.executeScript("window.scrollBy(0,-250)");
    }

    public void tapOnElement(WebElement element) {
        Actions actions = new Actions(ewd);
        actions.moveToElement(element).click().build().perform();
    }

    public boolean isElementPresent(WebElement element) {
        return element != null && element.isDisplayed();
    }
}




