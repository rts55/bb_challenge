package com.rjs55.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.String.*;

public class SearchResultPage extends BasePage{
    private static final String PAGE_TITLE = format("%s - Wikipedia", "Test");
    private static final By HEADING_IDENTIFIER = By.id("firstHeading");

    SearchResultPage(WebDriver driver) {        
        super(driver);
        waitForPageTitle(PAGE_TITLE);
    }

    public String getHeading() {
        return getDriver().findElement(HEADING_IDENTIFIER).getText();
    }
}
