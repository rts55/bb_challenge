package com.rts55.pages;

import com.rts55.domain.Computer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddComputerPage extends BasePage {

    private static final By COMPUTER_NAME_FIELD = By.id("name");
    private static final By INTRODUCED_DATE_FIELD = By.id("introduced");
    private static final By DISCONTINUED_DATE_FIELD = By.id("discontinued");
    private static final By COMPANY_NAME_SELECT_FIELD = By.id("company");
    private static final By CREATE_COMPUTER_BUTTON = By.cssSelector("input[value='Create this computer']");
    private static final By ERROR_IDENTIFIER = By.cssSelector(".error");

    AddComputerPage(WebDriver driver) {
        super(driver);
        waitForVisibilityOfElement(COMPUTER_NAME_FIELD);
    }

    public void enterComputerDetails(Computer computer) {
        enterText(COMPUTER_NAME_FIELD, computer.getComputerName());
        enterText(INTRODUCED_DATE_FIELD, computer.getIntroducedDate());
        enterText(DISCONTINUED_DATE_FIELD, computer.getDiscontinuedDate());
        selectCompany(COMPANY_NAME_SELECT_FIELD, computer.getCompany());
        clickElement(CREATE_COMPUTER_BUTTON);
    }


    public String getError() {
        waitForNumberOfSeconds(1);
        return getElementText(ERROR_IDENTIFIER);
    }

}
