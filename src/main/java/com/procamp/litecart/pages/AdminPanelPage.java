package com.procamp.litecart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;

public class AdminPanelPage extends BasePage {

    @FindBy(xpath = "//div[@id = 'logotype']")
    private WebElement siteLogo;

    @FindBy(xpath = "//div[@id = 'sidebar']//ul[@id='box-apps-menu']/li")
    private List<WebElement> listOfMenuItem;

    @FindBy(xpath = "//div[@class='panel-heading']")
    private List<WebElement> panelHeading;


    public AdminPanelPage(EventFiringWebDriver ewd) {
        super(ewd);
    }

    public boolean logoIsDisplayed() {
        return siteLogo.isDisplayed();

    }

    public void openListOfMenuItems() {
        int basicCount = listOfMenuItem.size();
        for (int j = 0; j < basicCount; j++) {
            String format = String.format("//div[@id = 'sidebar']//ul[@id='box-apps-menu']/li[%s]", j + 1);
            WebElement element = ewd.findElement(By.xpath(format));
            System.out.println(element.getText());
            element.click();
            Boolean isPresentHeading = panelHeading.size() > 0;
            System.out.println(isPresentHeading);


            List<WebElement> subElements = ewd.findElements(By.xpath(format.concat(String.format("//li"))));
            for (int i = 1; i <= subElements.size(); i++) {
                WebElement subElement = ewd.findElement(By.xpath(format.concat(String.format("//li[%s]", i))));
                if (!subElement.getAttribute("class").equals("selected")) {
                    System.out.println(subElement.getText());
                    subElement.click();
                    Boolean isPresentSubHeading = panelHeading.size() > 0;
                    System.out.println(isPresentSubHeading);


                }
            }
        }

    }
}