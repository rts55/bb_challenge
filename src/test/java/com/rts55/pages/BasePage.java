package com.rts55.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BasePage {

    private final WebDriver driver;

    private static final int DEFAULT_TIMEOUT = 30;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitForPageTitle(String pageTitle) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT)
                .until(titleIs(pageTitle));
    }

    protected void waitForVisibilityOfElement(By elementIdentifier) {
        new WebDriverWait(driver, 30).until(visibilityOf(driver.findElement(elementIdentifier)));
    }

    protected WebDriver getDriver() {
        return driver;
    }

}
