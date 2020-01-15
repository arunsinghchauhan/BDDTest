package com.company.project.keywords;

import static com.company.automation.utilities.YMLReader.getData;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.company.automation.utilities.GenericActions;
import com.company.automation.utilities.PropFileHandler;

public class DashboardActions extends GenericActions{
	PropFileHandler data=new PropFileHandler();

	public DashboardActions(WebDriver driver) {
        super(driver, "HomePage");		
	}
	
	public void gotoDropdown(){   	 	
    	element("inp_gotoDropdown").click();
    	
	}

}
