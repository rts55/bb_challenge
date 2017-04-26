package com.rts55.pages;

import com.rts55.ProjectDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pages {

    private final ProjectDriver webDriver;

    @Autowired
    public Pages(ProjectDriver webDriver) {
        this.webDriver = webDriver;
    }

    public HomePage homePage() {
        return new HomePage(webDriver.getWebDriver());
    }

    public AddComputerPage addComputerPage() {
        return new AddComputerPage(webDriver.getWebDriver());
    }

    public EditComputerPage editPage() {
        return new EditComputerPage(webDriver.getWebDriver());
    }

    public NoComputerPage noComputerFoundPage() {
        return new NoComputerPage(webDriver.getWebDriver());
    }
}
