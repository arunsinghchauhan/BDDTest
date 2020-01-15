package com.company.project.keywords;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import com.company.automation.utilities.PropFileHandler;
import com.company.automation.utilities.GenericActions;
import static com.company.automation.utilities.YMLReader.getData;

public class LoginPageActions extends GenericActions{
	PropFileHandler data=new PropFileHandler();
	private String s = "inp_domainName";

	public LoginPageActions(WebDriver driver) {
        super(driver, "LoginPage");
    }
	
	public void launchURL(){
    	driver.get(getData("Application URL"));
	}
	
	public void enterDomainName(){   	 	
    	element(s).sendKeys(getData("Credentials.Domain"));
    	Reporter.log("I Enter Domain Name: '" +getData("Credentials.Domain") +"'", true);
	}
	
	public void enterUserName(String userType){   	 	
    	element("inp_userName").sendKeys(getData("Credentials." +userType +".UserName"));
    	Reporter.log("I Enter User Name: '" +getData("Credentials." +userType +".UserName") +"'", true);
	}
	
	public void enterPassword(String userType){   	 	
    	element("inp_password").sendKeys(getData("Credentials." +userType +".Password"));
    	Reporter.log("I Enter Password: '" +getData("Credentials." +userType +".Password") +"'", true);
	}
	
	public void selectLoginButton() {
		element("btn_login").click();
		Reporter.log("I Click On Login Button", true);
	}
	
	public void clickVisitAdminLink(){
    	element("clk_AdminPageLink").click();
	}

	
}