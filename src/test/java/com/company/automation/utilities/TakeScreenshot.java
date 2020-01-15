/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.automation.utilities;

import static com.company.automation.utilities.ConfigPropertyReader.getProperty;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Reporter;
import cucumber.api.Scenario;

public class TakeScreenshot {

    WebDriver driver;
    String testname;
    String screenshotPath = "/target/Screenshots";

    public TakeScreenshot(String testname, WebDriver driver) {
        this.driver = driver;
        this.testname = testname;
    }

    public void takeScreenshot() {
        screenshotPath = (getProperty("screenshot-path") != null) ? getProperty("screenshot-path") : screenshotPath;
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_a");
        Date date = new Date();
        String date_time = dateFormat.format(date);
        File file = new File(System.getProperty("user.dir") + File.separator + screenshotPath + File.separator + this.testname
                + File.separator + date_time);
        boolean exists = file.exists();
        if (!exists) {
            new File(System.getProperty("user.dir") + File.separator + screenshotPath + File.separator + this.testname
                    + File.separator + date_time).mkdir();
        }

        File scrFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        try {
            String saveImgFile = System.getProperty("user.dir") + File.separator + screenshotPath
                    + File.separator + this.testname + File.separator + date_time
                    + File.separator + "screenshot.png";
            Reporter.log("[INFO]: Save Image File Path : " + saveImgFile, true);
            FileUtils.copyFile(scrFile, new File(saveImgFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void takeScreenShotOnException(Scenario scenario) {
        String takeScreenshot = getProperty("take-screenshot");
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                // InputStream is= new ByteArrayInputStream(screenshot);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
    }
}