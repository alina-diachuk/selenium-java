package com.procamp.litecart.utils;


import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.io.File;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class Listener extends AbstractWebDriverEventListener {

    @Override
    public void onException(Throwable throwable, WebDriver wd) {
        System.out.println("[Seems we have some problems:] "+throwable.getMessage().split(":")[0]);

        File tempFile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tempFile, new File(System.currentTimeMillis() + "screen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("[Screenshot captured]");
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver wd) {
        highlight(element, "green", wd);
    }

    public static <T extends WebElement> T highlight(T element, final String color, WebDriver driver) {
        if (element != null && element.getAttribute("__selenideHighlighting") == null) {
            for (int i = 1; i < 4; i++) {
                transform(element, color, i, driver);
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 4; i > 0; i--) {
                transform(element, color, i, driver);
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return element;
    }

    private static void transform(WebElement element, String color, int i, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].setAttribute('__selenideHighlighting', 'done'); " +
                        "arguments[0].setAttribute(arguments[1], arguments[2])",
                element,
                "style",
                "border: " + i + "px solid " + color + "; border-style: dotted; " +
                        "transform: scale(1, 1." + i + ");");
    }

}
