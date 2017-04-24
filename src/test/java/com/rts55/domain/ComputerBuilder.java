package com.rts55.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ComputerBuilder {

    private String computerName = "Dimension 4100";
    private String introducedDate = "";
    private String discontinuedDate = "";
    private String company = "IBM";
    private String companyName;
    private Computer computer;

    public Computer build() {
        return new Computer(computerName, introducedDate, discontinuedDate, company);
    }

    public Computer getComputer() {
        return computer;
    }

    public ComputerBuilder withComputerName(String computerName) {
        this.computerName = computerName;
        return this;
    }

    public ComputerBuilder withIntroducedDate(String introducedDate) {
        this.introducedDate = introducedDate;
        return this;
    }

    public ComputerBuilder withDiscontinuedDate(String discontinuedDate) {
        this.discontinuedDate = discontinuedDate;
        return this;
    }
}
