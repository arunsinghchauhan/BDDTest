package com.company.project.stepdefs;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.company.automation.testinitiator.TestSessionInitiator;

@CucumberOptions(monochrome = true, features = "src/test/resources/Feature_Files/", tags ={"@Login"}, format = { "pretty","html:target/cucumber-reports/cucumber-pretty","json:target/cucumber.json" })

public class RunnerTest extends AbstractTestNGCucumberTests {
	static TestSessionInitiator test;	
	
	@BeforeClass
	public void start() {
		test = new TestSessionInitiator(this.getClass().getSimpleName());
	}	
	
    @After
    public void embedScreenshot(cucumber.api.Scenario scenario) {    	
        Reporter.log("********************************************************", true);
        Reporter.log("Scenario Result: " + scenario.getStatus(),true);
        Reporter.log("********************************************************", true);
//        test.takescreenshot.takeScreenShotOnException(scenario);
    }

    /*@AfterClass
    public void closeTestSession() {
        test.terminateSession();
    }*/
}