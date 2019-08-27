package com.procamp.litecart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AdminPanelPage extends BasePage {

    @FindBy(xpath = "//div[@id = 'logotype']")
    private WebElement siteLogo;

    @FindBy(xpath = "//div[@id = 'box-apps-menu-wrapper']//ul[@id='box-apps-menu']//li")
    private List<WebElement> listOfMenuItem;


    public AdminPanelPage(WebDriver wd) {
        super(wd);
    }

    public void logoPresent() {
        siteLogo.isDisplayed();

    }

    public void openListOfMenuItems() {
        int basicCount = listOfMenuItem.size();
        for (int j = 0; j < basicCount; j++) {
            String format = String.format("//div[@id = 'box-apps-menu-wrapper']//ul[@id='box-apps-menu']//li[%s]", j + 1);
            WebElement element  = wd.findElement(By.xpath(format));
            System.out.println(element.getText());
            element.click();
        }
    }
}
