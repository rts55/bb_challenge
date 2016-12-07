package com.rjs55.pages;

import com.rjs55.ProjectDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pages {

    private final ProjectDriver webDriver;

    @Autowired
    public Pages(ProjectDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WikipediaHomePage wikipediaHomePage() {
        return new WikipediaHomePage(webDriver.getWebDriver());
    }

    public SearchResultPage searchResultPage() {
        return new SearchResultPage(webDriver.getWebDriver());
    }
}
