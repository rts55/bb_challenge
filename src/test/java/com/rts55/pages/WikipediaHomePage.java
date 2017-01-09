package com.rts55.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikipediaHomePage extends BasePage{

    private static final String PAGE_TITLE = "Wikipedia, the free encyclopedia";
    private static final By SEARCH_TEXT_BOX = By.id("searchInput");
    private static final By SEARCH_BUTTON_IDENTIFIER = By.id("searchButton");

    WikipediaHomePage(WebDriver webDriver) {
        super(webDriver);
        waitForPageTitle(PAGE_TITLE);
    }

    public void enterText(String s) {
        waitForVisibilityOfElement(SEARCH_TEXT_BOX);
        getDriver().findElement(SEARCH_TEXT_BOX).sendKeys(s);
    }

    public void search() {
        getDriver().findElement(SEARCH_BUTTON_IDENTIFIER).click();
    }
}
