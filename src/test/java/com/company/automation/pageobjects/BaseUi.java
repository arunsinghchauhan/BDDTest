/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.automation.pageobjects;

import static com.company.automation.utilities.ConfigPropertyReader.getProperty;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.company.automation.utilities.PropFileHandler;
import com.company.automation.utilities.SeleniumWait;

public class BaseUi	{

    protected static WebDriver driver;
    protected static SeleniumWait wait;
    private String pageName;
    protected final int AJAX_WAIT = 5;
    
    PropFileHandler data=new PropFileHandler();

    @SuppressWarnings("static-access")
	protected BaseUi(WebDriver driver, String pageName) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.pageName = pageName;
        this.wait = new SeleniumWait(driver, Integer.parseInt(getProperty("configuration.properties", "timeout")));
    }    

    protected String logMessage(String message) {
        Reporter.log(message, true);
        return message;
    }

    protected void switchToFrame(WebElement element) {
        wait.waitForElementToBeVisible(element);
        driver.switchTo().frame(element);
    }
    
    public void switchToFrame(int i) {
        driver.switchTo().frame(i);
    }

    public void switchToFrame(String id) {
        driver.switchTo().frame(id);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void clickUsingJavaScriptClickEvent(String locatorValue) {
        String path1 = locatorValue;
        String js = "var targetElement = document.evaluate(\"" + path1 + "\",document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null ).singleNodeValue;"
                + "targetElement.click();";
        ((JavascriptExecutor) driver).executeScript(js);
    }
    
    protected void scrollDown(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void hoverClick(WebElement element) {
        wait.hardWait(2);
        Actions hoverClick = new Actions(driver);
        Actions MenuItems = hoverClick.moveToElement(element);
        wait.hardWait(2);
        MenuItems.click().build().perform();
    }

    protected void hover(WebElement element) {
        Actions hoverOver = new Actions(driver);
        hoverOver.moveToElement(element).build().perform();
        hoverOver.perform();
    }
}