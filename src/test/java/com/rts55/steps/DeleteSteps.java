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
public class DeleteSteps {

    @Autowired
    private ComputerBuilder computerBuilder;
    @Autowired
    private CurrentUser currentUser;
    @Autowired
    private Pages pages;

    @Given("^the user selects the record for computer (.*)$")
    public void theUserSelectsTheRecordForComputer(String computerName) throws Throwable {
        Computer computer = computerBuilder.withComputerName(computerName).build();
        currentUser.get().setComputer(computer);
        pages.homePage().filterByName(computerName);
        pages.homePage().selectComputer(computerName);
    }

    @When("^the user deletes the record from the database$")
    public void theUserDeletesTheRecordFromTheDatabase() throws Throwable {
        pages.editPage().deleteComputer();
    }

    @Then("^the computer will no longer be in the database$")
    public void theComputerWillNoLongerBeInTheDatabase() throws Throwable {
        assertThat(pages.homePage().getDoneMessage(),
                is("Done! Computer has been deleted"));
    }
}
