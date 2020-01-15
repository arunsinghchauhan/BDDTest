package com.company.automation.utilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWait{
    
    WebDriver driver;
    WebDriverWait wait;
    
    public int timeout;
    
    public SeleniumWait(WebDriver driver, int timeout) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
        this.timeout = timeout;
    }
    
    public WebElement waitForElementToBeVisible(WebElement element) {
        return (WebElement) wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public List<WebElement> waitForElementsToBeVisible(List<WebElement> elements) {
        return (List<WebElement>) wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
    
    public boolean waitForElementToBeInVisible(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator)) != null;
    }
    
    public WebElement waitForElementToBeClickable(WebElement element) {
        return (WebElement) wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    public void resetImplicitTimeout(int newTimeOut) {
        try {
            driver.manage().timeouts().implicitlyWait(newTimeOut, TimeUnit.SECONDS);
        } catch (Exception e) {	
        }
    }

    public void waitForPageToLoadCompletely() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*")));
    }

    public void hardWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}