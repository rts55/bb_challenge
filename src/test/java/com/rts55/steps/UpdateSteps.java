package com.rts55.steps;

import com.rts55.domain.Computer;
import com.rts55.domain.ComputerBuilder;
import com.rts55.domain.CurrentUser;
import com.rts55.pages.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static java.lang.String.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by richardsuller on 24/04/2017.
 */
@SuppressWarnings("SpringJavaAutowiredMembersInspection")
public class UpdateSteps {

    @Autowired
    private CurrentUser currentUser;
    @Autowired
    private Pages pages;
    @Autowired
    private ComputerBuilder computerBuilder;

    @Given("^the user selects an existing record to edit$")
    public void theUserSelectsAnExistingRecordToEdit() throws Throwable {
        Computer computer = computerBuilder.build();
        pages.homePage().filterByName(computer.getComputerName());
        pages.homePage().selectComputer(computer.getComputerName());
    }

    @When("^the user updates the company name$")
    public void theUserUpdatesTheCompanyName() throws Throwable {
        Computer computer = computerBuilder.withComputerName("New name").build();
        currentUser.get().setComputer(computer);
        pages.editPage().replaceComputerName(computer.getComputerName());
    }

    @Then("^the updated computer will be in the database$")
    public void theUpdatedComputerWillBeInTheDatabase() throws Throwable {
        assertThat(pages.homePage().getDoneMessage(),
                containsString(format("Done! Computer %s has been updated",
                        currentUser.get().getComputer().getComputerName())));
    }
}
