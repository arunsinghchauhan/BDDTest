package com.company.project.stepdefs;

import static com.company.project.stepdefs.RunnerTest.test;
import cucumber.api.java.en.And;

public class CommonPageStepDef {

	 @And("^I Select Button With Name \"([^\"]*)\"$")
	 public void SelectButtonWithName(String ButtonName) {		 
		 test.common.selectButtonWithName(ButtonName);
	 }
	 
	@And("^I Select Button With Value \"([^\"]*)\"$")
	 public void SelectButtonWithValue(String ButtonValue) {		 
		 test.common.selectButtonWithValue(ButtonValue);
	 }
	 
	 @And("^I verify page title is \"([^\"]*)\"$")
	 public void VerifyPageTitle(String Title) {		 
		 test.common.verifyPageTitle(Title);
	}
	
	@And("^I select link \"([^\"]*)\"$")
	 public void SelectLink(String LinkName) {
		test.common.selectLink(LinkName);
	}
	
	@And("^I Enter \"([^\"]*)\" as \"([^\"]*)\"$")
	public void SelectFirstNameTextArea(String labelName,String textName) {
		test.common.selectFirstNameTextArea(labelName,textName);
	}
	
	@And("^I Enter the \"([^\"]*)\" as \"([^\"]*)\"$")
	public void SelectLastNameTextArea(String labelName,String textName) {
		test.common.selectLastNameTextArea(labelName,textName);
	}
	
	@And("^I Enter mailid \"([^\"]*)\" as \"([^\"]*)\"$")
	public void SelectEmailTextArea(String labelName,String textName) {
		test.common.selectEmailTextArea(labelName,textName);
	}
	
	@And("^I Enter username \"([^\"]*)\" as \"([^\"]*)\"$")
	public void SelectUsernameTextArea(String labelName,String textName) {
		test.common.selectUsernameTextArea(labelName,textName);
	}
	@And("^I Enter password \"([^\"]*)\" as \"([^\"]*)\"$")
	public void SelectPasswordTextArea(String labelName,String textName) {
		test.common.selectPasswordTextArea(labelName,textName);
	}
	@And("^I Enter a \"([^\"]*)\" as \"([^\"]*)\"$")
	public void SelectDescriptionTextArea(String labelName,String textName) {
		test.common.selectDescriptionTextArea(labelName,textName);
	}
	@And("^I Click \"([^\"]*)\"$")
	public void AddUser(String labelName) {
		test.common.addUser(labelName);
	}
	
}