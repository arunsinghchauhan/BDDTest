package com.company.project.stepdefs;

import static com.company.project.stepdefs.RunnerTest.test;

import cucumber.api.java.en.And;

public class SignupStepDef {

	 @And("^I Click on link \"([^\"]*)\"$")
	 public void SignuptoApplication(String labelName) {
		 test.signup.signuptoApplication(labelName);

	 }
	 @And("^I Select text \"([^\"]*)\" as \"([^\"]*)\"$")
	 
	 public void SelectDomainName(String labelName,String textName) {
		 test.signup.selectDomainName(labelName,textName);

	 }
	 @And("^I Click on terms of service checkbox")
	 public void ClickOnTermsOfservice() {
		 test.signup.clickOnTermsOfservice();

	 }
	 @And("^I Click on create account button")
	 public void ClickOnCreateAccountBtn() {
		 test.signup.clickOnCreateAccountBtn();

	 }

}
