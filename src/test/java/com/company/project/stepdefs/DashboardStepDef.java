package com.company.project.stepdefs;

import cucumber.api.java.en.And;
import static com.company.project.stepdefs.RunnerTest.test;

public class DashboardStepDef {

	@And("^I Navigate to goto dropdown$")
	 public void GotoDropdown() {
		 test.home.gotoDropdown();
	 }
	
}