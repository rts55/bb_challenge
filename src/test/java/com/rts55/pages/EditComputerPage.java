package com.rts55.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by richardsuller on 24/04/2017.
 */
public class EditComputerPage extends BasePage {


    private static final By COMPUTER_NAME_FIELD = By.id("name");
    private static final By SAVE_COMPUTER_BUTTON = By.cssSelector("input[value='Save this computer']");
    private static final By DELETE_BUTTON = By.cssSelector("input[value='Delete this computer']");

    EditComputerPage(WebDriver driver) {
        super(driver);
        waitForPageHeadingToContainText("Edit computer");
    }

    public void replaceComputerName(String computerName) {
        replaceFieldText(COMPUTER_NAME_FIELD, computerName);
        getDriver().findElement(SAVE_COMPUTER_BUTTON).click();
    }

    public void deleteComputer() {
        clickElement(DELETE_BUTTON);
    }

    public String getPageHeading() {
        waitForVisibilityOfElement(SAVE_COMPUTER_BUTTON);
        return getPageHeadingText();
    }
}
