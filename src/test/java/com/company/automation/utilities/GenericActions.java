package com.company.automation.utilities;

import org.openqa.selenium.WebDriver;
import com.company.automation.pageobjects.GetPage;

public class GenericActions extends GetPage{

	public GenericActions(WebDriver driver, String pageName) {
		super(driver, pageName);
		webdriver = driver;
	}	
}