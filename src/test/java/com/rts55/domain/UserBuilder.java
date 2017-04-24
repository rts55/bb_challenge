package com.rts55.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserBuilder {

    @Value("${username}")
    private String main_username;
    @Value("${password}")
    private String main_password;

    public User build() {
        return new User(main_username, main_password);
    }

}
