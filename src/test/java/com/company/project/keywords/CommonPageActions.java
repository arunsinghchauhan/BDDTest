package com.company.project.keywords;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import java.util.UUID;
import com.company.automation.utilities.PropFileHandler;
import com.company.automation.utilities.GenericActions;

public class CommonPageActions extends GenericActions{
	PropFileHandler data=new PropFileHandler();

	public CommonPageActions(WebDriver driver) {
        super(driver, "Common");
    }
	
	public void selectButtonWithName(String ButtonName){
		wait.waitForElementToBeClickable(element("btn_withName", ButtonName));
    	element("btn_withName", ButtonName).click();
    	Reporter.log("I Select Button '" +ButtonName +"'", true);
	}
	
	public void selectButtonWithValue(String ButtonValue){
		wait.waitForElementToBeClickable(element("btn_withValue", ButtonValue));
    	element("btn_withValue", ButtonValue).click();
    	Reporter.log("I Select Button '" +ButtonValue +"'", true);
	}
	
	public void verifyPageTitle(String Title) {
		driver.getTitle().equals(Title);
		Reporter.log("Page Title Is '" +Title +"'", true);
	}
	
	public void selectLink(String LinkName) {
		element("link_withLabel", LinkName).click();
		Reporter.log("I Select Link '" +LinkName +"'", true);
	}
	
	public void selectFirstNameTextArea(String labelName,String textName) {
		element("inp_withLabel", labelName).sendKeys(textName);
	}
	public void selectLastNameTextArea(String labelName,String textName) {
		element("inp_withLabel", labelName).sendKeys(textName);
	}
	public void selectEmailTextArea(String labelName,String textName) {		
		String uuid = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 7);
		System.out.println(uuid);
		element("inp_withLabel", labelName).sendKeys(uuid+"@gmail.com");
	}
	
	public void selectUsernameTextArea(String labelName,String textName) {
		wait.hardWait(1);
		element("inp_withLabel", labelName).clear();
		wait.hardWait(1);
		String uuid= UUID.randomUUID().toString().replaceAll("-", "").substring(0, 7);
		element("inp_withLabel", labelName).sendKeys(uuid);
	}
	public void selectPasswordTextArea(String labelName,String textName) {
		element("inp_withLabel", labelName).sendKeys(textName);
	}
	public void selectDescriptionTextArea(String labelName,String textName) {
		element("inp_descriptionField", labelName).sendKeys(textName);
	}
	public void addUser(String labelName) {
		element("clk_btn", labelName).click();
	}
}