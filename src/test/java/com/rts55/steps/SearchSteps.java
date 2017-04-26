package com.rts55.steps;

import com.rts55.domain.Computer;
import com.rts55.domain.ComputerBuilder;
import com.rts55.domain.CurrentUser;
import com.rts55.pages.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by richardsuller on 25/04/2017.
 */
@SuppressWarnings("SpringJavaAutowiredMembersInspection")
public class SearchSteps {

    @Autowired
    private ComputerBuilder computerBuilder;
    @Autowired
    private CurrentUser currentUser;
    @Autowired
    private Pages pages;

    @Given("^the user provides the computer name \"([^\"]*)\"$")
    public void theUserProvidesTheComputerName(String computerName) throws Throwable {
        Computer computer = computerBuilder.withComputerName(computerName).build();
        currentUser.get().setComputer(computer);
    }

    @When("^the user searches for the computer$")
    public void theUserSearchesForTheComputer() throws Throwable {
        pages.homePage().filterByName(currentUser.get().getComputer().getComputerName());
    }

    @Then("^the user will be able to select the computer and edit the details$")
    public void theUserWillBeAbleToSelectTheComputerAndEditTheDetails() throws Throwable {
        pages.homePage().selectComputer(currentUser.get().getComputer().getComputerName());
        assertThat(pages.editPage().getPageHeading(), is("Edit computer"));
    }

    @Then("^the user will be informed there are no records to display$")
    public void theUserWillBeInformedThereAreNoRecordsToDisplay() throws Throwable {
        assertThat(pages.noComputerFoundPage().getWarningMessage(),is("Nothing to display"));
    }
}
