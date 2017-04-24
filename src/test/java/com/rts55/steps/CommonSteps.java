package com.rts55.steps;

import com.rts55.domain.CurrentUser;
import com.rts55.domain.UserBuilder;
import cucumber.api.java.en.Given;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("SpringJavaAutowiredMembersInspection")
@Slf4j
public class CommonSteps {

    @Autowired
    private CurrentUser currentUser;
    @Autowired
    private UserBuilder userBuilder;

    @Given("^I am a valid user$")
    public void iAmAValidUser() throws Throwable {
        currentUser.set(userBuilder.build());
        log.info("Current user {}", currentUser.get());
    }
}
