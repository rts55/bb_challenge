package com.rts55.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

class BasePage {

    private final WebDriver driver;
    private static final int DEFAULT_TIMEOUT = 30;
    private static final By PAGE_HEADING = By.cssSelector("#main>h1");


    BasePage(WebDriver driver) {
        this.driver = driver;
    }

    void waitForPageTitle(String pageTitle) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT)
                .until(titleIs(pageTitle));
    }

    void waitForVisibilityOfElement(By elementIdentifier) {
        new WebDriverWait(driver, 30).until(visibilityOfElementLocated(
                (elementIdentifier)));
    }

    void waitForNumberOfSeconds(int numberOfSeconds) {
        getDriver().manage().timeouts().implicitlyWait(numberOfSeconds, TimeUnit.SECONDS);
    }

    boolean waitForPageHeadingToContainText(String pageHeading) {
        waitForNumberOfSeconds(5);
        return getPageHeadingText().contains(pageHeading);
    }

    String getPageHeadingText() {
        return getDriver().findElement(PAGE_HEADING).getText();
    }

    void enterText(By elementIdentifier, String textToEnter) {
        waitForVisibilityOfElement(elementIdentifier);
        getDriver().findElement(elementIdentifier).sendKeys(textToEnter);
    }

    void clickElement(By elementIdentifier) {
        waitForVisibilityOfElement(elementIdentifier);
        getDriver().findElement(elementIdentifier).click();
    }

    void selectCompany(By elementIdentifier, String textToSelect) {
        new Select(getDriver().findElement(elementIdentifier)).selectByVisibleText(textToSelect);
    }

    void selectElementByLinkText(String linkText) {
        getDriver().findElement(By.linkText(linkText)).click();
    }

    String getElementText(By elementIdentifier) {
        return getDriver().findElement(elementIdentifier).getText();

    }

    void replaceFieldText(By elementIdentifier, String textToEnter) {
        getDriver().findElement(elementIdentifier).clear();
        getDriver().findElement(elementIdentifier).sendKeys(textToEnter);
    }

    WebDriver getDriver() {
        return driver;
    }

}
