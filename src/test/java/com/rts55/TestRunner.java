package com.rts55;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},
        tags = "@regression",
        monochrome = true)


public class TestRunner {

    @AfterClass
    public static void setup() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setTestRunnerOutput("Test Output");
    }
}
