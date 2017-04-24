package com.rts55.domain;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class User {

    private String username;
    private String password;
    private Computer computer;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}
