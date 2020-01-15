package com.company.automation.testinitiator;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import static com.company.automation.utilities.ConfigPropertyReader.getProperty;
import static com.company.automation.utilities.YMLReader.setYamlFilePath;
import com.company.automation.utilities.TakeScreenshot;
import com.company.project.keywords.CommonPageActions;
import com.company.project.keywords.DashboardActions;
import com.company.project.keywords.LoginPageActions;
import com.company.project.keywords.SignupPageAction;

	public class TestSessionInitiator {

		protected WebDriver driver;
		private final WebDriverFactory wdfactory;
		String browser;
		
		public LoginPageActions login;    
		public DashboardActions home;
		public CommonPageActions common;
		public SignupPageAction signup;
		public TakeScreenshot takescreenshot;
		
	public WebDriver getDriver() {
        return this.driver;
    }
	
	private void classObjectInitialize() {
		login = new LoginPageActions(driver);    	
        home = new DashboardActions(driver);
        common = new CommonPageActions(driver);
        signup= new SignupPageAction(driver);
		takescreenshot = new TakeScreenshot(browser, driver);
	}
	
	public TestSessionInitiator(String testname) {
        wdfactory = new WebDriverFactory();
        testInitiator(testname);
    }
	
	private void testInitiator(String testname) {
        setYamlFilePath();
        browserConfiguration();
        classObjectInitialize();
        takescreenshot = new TakeScreenshot(testname, this.driver);
    }
	
	private void browserConfiguration() {
        driver = wdfactory.getDriver(_getSessionConfig());
        driver.manage().window().maximize();
        Dimension d = new Dimension(1920,1080);
		//Resize the current window to the given dimension
		driver.manage().window().maximize();;
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(getProperty("timeout")),TimeUnit.SECONDS);
    }
	
	private Map<String, String> _getSessionConfig() {
        String[] configKeys = {"tier", "browser", "seleniumserver",
            "seleniumserverhost", "timeout", "driverpath"};
        Map<String, String> config = new HashMap<String, String>();
        for (String string : configKeys) {
            config.put(string, getProperty("./configuration.properties", string));
        }
        return config;
    }
	
	public void terminateSession() {
        driver.quit();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}