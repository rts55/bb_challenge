package com.rts55.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by richardsuller on 25/04/2017.
 */
public class NoComputerPage extends BasePage{

    private static final By NO_COMPUTERS_WARNING = By.cssSelector(".well>em");

    NoComputerPage(WebDriver driver) {
        super(driver);
        waitForPageHeadingToContainText("No computers found");
    }

    public String getWarningMessage() {
        return getElementText(NO_COMPUTERS_WARNING);
    }
}
