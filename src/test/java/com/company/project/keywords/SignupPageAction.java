package com.company.project.keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.company.automation.utilities.GenericActions;

public class SignupPageAction extends GenericActions{

	public SignupPageAction(WebDriver driver) {
		super(driver, "SignUp");
		// TODO Auto-generated constructor stub
	}

	public void signuptoApplication(String labelName){   	 	
    	element("btn_withtext").click();
    	wait.hardWait(2);
    	
	}
	
	public void selectDomainName(String labelName,String textName) {
		element("txtfield_name", labelName).sendKeys(textName);
	}
	public void selectEmail(String labelName,String textName) {
		element("txtfield_name", labelName).sendKeys(textName);
	}
	public void selectName(String labelName,String textName) {
		element("txtfield_name", labelName).sendKeys(textName);
	}
	public void selectUserName(String labelName,String textName) {
		element("txtfield_name", labelName).sendKeys(textName);
	}
	public void selectPassword(String labelName,String textName) {
		element("txtfield_name", labelName).sendKeys(textName);
	}
	public void clickOnTermsOfservice(){   	 	
    	element("btn_checkbox").click();
    	
	}
	public void clickOnCreateAccountBtn(){   	 	
    	element("btn_withvalue").click();
    	
	}
}
