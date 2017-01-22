package com.rts55.domain;

public enum ClientType {

    MAIN("main"),
    SECONDARY("secondary");

    private String username;

    ClientType(String username) { this.username = username;}

    public String getUsername() {
        return username;
    }
}
