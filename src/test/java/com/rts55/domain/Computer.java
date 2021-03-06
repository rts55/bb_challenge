package com.rts55.domain;

import lombok.Data;

@Data
public class Computer {

    private String computerName;
    private String introducedDate;
    private String discontinuedDate;
    private String company;

    Computer(String computerName, String introducedDate, String discontinuedDate, String company) {
        this.computerName = computerName;
        this.introducedDate = introducedDate;
        this.discontinuedDate = discontinuedDate;
        this.company = company;
    }

}
