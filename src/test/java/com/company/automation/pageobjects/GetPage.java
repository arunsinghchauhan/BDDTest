package com.company.automation.pageobjects;

import static com.company.automation.pageobjects.ObjectFileReader.getELementFromFile;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import com.company.automation.utilities.ReportMsg;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import static org.testng.Assert.*;
import org.testng.Reporter;

public class GetPage extends BaseUi {
    public WebDriver webdriver;
    public String pageName;
    String windowHandle;

    public GetPage(WebDriver driver, String pageName) {
        super(driver, pageName);
        this.webdriver = driver;
        this.pageName = pageName;
    }
    
    public void clickElementUsingJavaScript(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
       }

    public void selectFromDropDownByValue(WebElement e, String value) {
        Select dropdown = new Select(e);
        dropdown.selectByValue(value);
        Reporter.log(value + " Is Selected From Drop-Down");
    }
    
    public void selectFromDropDownByIndex(WebElement e, int index) {
        Select dropdown = new Select(e);
        dropdown.selectByIndex(index);
        Reporter.log(index + " Is Selected From Drop-Down");
    }
    
    public void selectFromDropDownByText(WebElement e, String text) {
        Select dropdown = new Select(e);
        dropdown.selectByVisibleText(text);
        Reporter.log(text + " Is Selected From Drop-Down");
    }
    
    protected List<WebElement> elements(String elementToken, String replacement) {
        return webdriver.findElements(getLocator(elementToken, replacement));
    }
    
    protected List<WebElement> elements(String elementToken, String replacement1, String replacement2) {
        return webdriver.findElements(getLocator(elementToken, replacement1, replacement2));
    }

    protected List<WebElement> elements(String elementToken) {
        return elements(elementToken, "");
    }

    protected WebElement element(String elementToken) {
        return element(elementToken,"");
    }

    protected WebElement element(String elementToken, String replacement)
            throws NoSuchElementException {
        WebElement elem = null;
        try {
            elem = wait.waitForElementToBeVisible(webdriver
                    .findElement(getLocator(elementToken, replacement)));
        } catch (NoSuchElementException excp) {
            fail(logMessage("[ASSERT FAILED]: Element " + elementToken
                    + " not found on the " + this.pageName + " !!!"));
        } catch (NullPointerException npe) {

        }
        return elem;
    }
    
    protected WebElement element(String elementToken, String replacement1, String replacement2) {
    	  WebElement elem = null;
    	  try {
    	   elem = wait.waitForElementToBeVisible(
    	     webdriver.findElement(getLocator(elementToken, replacement1, replacement2)));
    	  } catch (NoSuchElementException excp) {
    	   ReportMsg.fail("No such Element Found Exception caught!!!!");
    	   ReportMsg.fail("Element " + elementToken + " not found on the " + this.pageName + " !!!");
    	  } catch (Exception npe) {
    	   ReportMsg.fail(npe.getLocalizedMessage());
    	   ReportMsg.fail("General Exception cought Exception caught!!!!");
    	   ReportMsg.fail("Element " + elementToken + " not found on the " + this.pageName + " !!!");
    	  }
    	  return elem;
    	 }

    protected By getLocator(String elementToken) {
        return getLocator(elementToken, "");
    }

    protected By getLocator(String elementToken, String replacement) {
        String[] locator = getELementFromFile(this.pageName, elementToken);
        locator[2] = locator[2].replaceAll("\\$\\{.+\\}", replacement);
        return getBy(locator[1].trim(), locator[2].trim());
    }

    protected By getLocator(String elementToken, String replacement1, String replacement2) {
        String[] locator = getELementFromFile(this.pageName, elementToken);
        locator[2] = StringUtils.replace(locator[2], "${value}", replacement1);
        locator[2] = StringUtils.replace(locator[2], "%{text}", replacement2);        
        System.out.println(locator[2]);
        return getBy(locator[1].trim(), locator[2].trim());
    }

    private By getBy(String locatorType, String locatorValue) {
        switch (Locators.valueOf(locatorType)) {
            case id:
                return By.id(locatorValue);
            case xpath:
                return By.xpath(locatorValue);
            case css:
                return By.cssSelector(locatorValue);
            case name:
                return By.name(locatorValue);
            case classname:
                return By.className(locatorValue);
            case linktext:
                return By.linkText(locatorValue);
            default:
                return By.id(locatorValue);
        }
    }
}