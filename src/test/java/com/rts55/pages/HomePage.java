package com.rts55.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final String PAGE_TITLE = "Computers database";
    private static final By ADD_NEW_COMPUTER = By.id("add");
    private static final By FILTER_FIELD = By.id("searchbox");
    private static final By FILTER_BUTTON = By.id("searchsubmit");

    HomePage(WebDriver driver) {
        super(driver);
        waitForPageTitle(PAGE_TITLE);
    }

    public String getHeading() {
        return getDriver().findElement(ADD_NEW_COMPUTER).getText();
    }

    public void clickAddNewComputer() {
        clickElement(ADD_NEW_COMPUTER);
    }

    public void filterByName(String computerName) {
        enterText(FILTER_FIELD, computerName);
        clickElement(FILTER_BUTTON);
    }


}
