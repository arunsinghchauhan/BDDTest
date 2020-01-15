package com.company.project.stepdefs;

import cucumber.api.java.en.And;
import static com.company.project.stepdefs.RunnerTest.test;

public class LoginPageStepDef {
	
	 @And("^I Launch Application URL$")
	 public void LaunchURL() {
		 test.login.launchURL();
	 }
	 
	 
	 @And("^I Login As \"([^\"]*)\"$")
	 public void LoginIntoApplication(String UserType) {
		 test.login.enterDomainName();
		 test.login.enterUserName(UserType);
		 test.login.enterPassword(UserType);
		 test.login.selectLoginButton();
	 }
	 
	 @And("^I click on Visit your Admin page$")
	 public void ClickVisitAdminLink()
	 {
		 test.login.clickVisitAdminLink();
	 }
}