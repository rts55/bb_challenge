package com.rts55.steps;

import com.rts55.domain.Computer;
import com.rts55.domain.ComputerBuilder;
import com.rts55.domain.CurrentUser;
import com.rts55.domain.UserBuilder;
import com.rts55.pages.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SuppressWarnings("SpringJavaAutowiredMembersInspection")
@Slf4j
public class CreateSteps {

    private static final String INVALID_FORMATTED_DATE = "17/01/2017";

    @Autowired
    private Pages pages;

    @Autowired
    private CurrentUser currentUser;

    @Autowired
    private UserBuilder userBuilder;

    @Autowired
    private ComputerBuilder computerBuilder;

    @Given("^I am a valid user$")
    public void iAmAValidUser() throws Throwable {
        currentUser.set(userBuilder.build());
        log.info("Current user {}", currentUser.get());
    }

    @Given("^the user has valid details for a new computer$")
    public void theUserHasValidDetailsForANewComputer() throws Throwable {
        Computer computer = computerBuilder.build();
        currentUser.get().setComputer(computer);
    }

    @Given("^the user does not provide a computer name$")
    public void theUserDoesNotProvideAComputerName() throws Throwable {
        Computer computer = computerBuilder.withComputerName("").build();
        currentUser.get().setComputer(computer);
    }

    @Given("^the user provides an invalid Introduced date$")
    public void theUserProvidesAnInvalidIntroducedDate() throws Throwable {
        Computer computer = computerBuilder.withIntroducedDate(INVALID_FORMATTED_DATE).build();
        currentUser.get().setComputer(computer);
    }

    @Given("^the user provides an invalid discontinued date$")
    public void theUserProvidesAnInvalidDiscontinuedDate() throws Throwable {
        Computer computer = computerBuilder.withDiscontinuedDate(INVALID_FORMATTED_DATE).build();
        currentUser.get().setComputer(computer);
    }

    @When("^the user adds the new computer$")
    public void theUserAddsTheNewComputer() throws Throwable {
        pages.homePage().clickAddNewComputer();
        pages.addComputerPage().enterComputerDetails(currentUser.get().getComputer());
    }

    @Then("^the computer will be added to the database$")
    public void theComputerWillBeAddedToTheDatabase() throws Throwable {
        pages.homePage().filterByName(currentUser.get().getComputer().getComputerName());
    }

    @Then("^the user will be informed the computer name is required$")
    public void theUserWillBeInformedTheComputerNameIsRequired() throws Throwable {
        assertThat(pages.addComputerPage().getError(), is("Computer name\n" +
                "Required"));
    }

    @Then("^the user will be informed the date is invalid$")
    public void theUserWillBeInformedTheDateIsInvalid() throws Throwable {
        assertThat(pages.addComputerPage().getError(), is("Introduced date\n" +
                "Date ('yyyy-MM-dd')"));
    }

    @Then("^the user will be informed the discontinued date is invalid$")
    public void theUserWillBeInformedTheDiscontinuedDateIsInvalid() throws Throwable {
        assertThat(pages.addComputerPage().getError(), is("Discontinued date\n" +
                "Date ('yyyy-MM-dd')"));
    }
}
