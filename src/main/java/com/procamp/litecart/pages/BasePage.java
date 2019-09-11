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

public class BasePage {

    public EventFiringWebDriver ewd;


    public BasePage(EventFiringWebDriver ewd) {
        this.ewd = ewd;
        PageFactory.initElements(this.ewd, this);
    }

    public void waitElementToClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(ewd, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForPageLoad() {
        new WebDriverWait(ewd, 60).until((ExpectedCondition<Boolean>) ewd ->
                ((JavascriptExecutor)ewd).executeScript("return document.readyState").equals("complete"));
    }

    public void scrollToElement(WebElement element){
        Actions actions = new Actions(ewd);
        actions.moveToElement(element);
        actions.perform();
    }

}
