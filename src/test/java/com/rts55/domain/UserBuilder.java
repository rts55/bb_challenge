package com.rts55.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserBuilder {

    private static final String USERNAME_FORMAT = "%s_username";
    private static final String PASSWORD_FORMAT = "%s_password";

    @Value("${main_username}")
    private String main_username;
    @Value("${main_password}")
    private String main_password;

    @Value("${secondary_username}")
    private String secondary_username;
    @Value("${secondary_password}")
    private String secondary_password;

    private ClientType clientType;

    public User build() {
        if (null != clientType) {
            return new User(resolveUsername(clientType), resolvePassword(clientType));
        }
        return new User(main_username, main_password);
    }

    public UserBuilder clientType(ClientType clientType) {
        this.clientType = clientType;
        return this;
    }

    private String resolveUsername(ClientType clientType) {

        try {
            return (String) this.getClass().getDeclaredField(String.format(USERNAME_FORMAT, clientType.getUsername())).get(this);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return "";

    }

    private String resolvePassword(ClientType clientType) {
        try {
            return (String) this.getClass().getDeclaredField(String.format(PASSWORD_FORMAT, clientType.getUsername())).get(this);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return "";
    }

}
