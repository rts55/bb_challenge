package com.rts55.steps;

import com.rts55.pages.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SearchSteps {

    @Autowired
    private Pages pages;

    private String subject;

    @Given("^I require information about \"([^\"]*)\"$")
    public void iRequireInformationAbout(String subject) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.subject = subject;
    }

    @When("^I search for the given subject$")
    public void iSearchForTheGivenSubject() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        pages.wikipediaHomePage().enterText(subject);
        pages.wikipediaHomePage().search();
    }

    @Then("^I will be shown some real interesting stuff$")
    public void iWillBeShownSomeRealInterestingStuff() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertThat(pages.searchResultPage().getHeading(), is(subject));
    }
}
