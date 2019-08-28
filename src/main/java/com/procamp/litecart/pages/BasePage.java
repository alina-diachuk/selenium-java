package com.procamp.litecart.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver wd;


    public BasePage(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }

    public void waitElementToClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForPageLoad() {
        new WebDriverWait(wd, 60).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

}
