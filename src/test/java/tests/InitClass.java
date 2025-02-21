package tests;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

// Ensure that annotations always come from org.testng
import org.testng.annotations.*;
import io.appium.java_client.AppiumDriver;
import utils.CustomKeywords;
import utils.IOSCapabilities;
import utils.AndroidCapabilities;

public class InitClass {
	
	AppiumDriver driver;
	public ObjectStore objects;
	public CustomKeywords CustomKeywords;
	
	@BeforeMethod
	public void beforeMethod() {
		try {
			// This gets the execution platform from the run config
			String configPlatform = System.getProperty("platform");
			System.out.println("Execution target platform: " + configPlatform);
			
			// This sets up the device etc. to be run on
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			if(configPlatform.equalsIgnoreCase("Android")) {
				// All Android setup is defined in the below AndroidCapabilities util
				capabilities = AndroidCapabilities.getCapabilities();
				
			} else if (configPlatform.equalsIgnoreCase("iOS")) {
				// All iOS setup is defined in the below IOSCapabilities util
				capabilities = IOSCapabilities.getCapabilities();
			} else {
				// If platform variable isn't provided, exception here is thrown
				throw new IllegalArgumentException("Invalid platform: " + configPlatform);
			}
			
			// This is the default 
			URL url = new URL("http://127.0.0.1:4723/");
			
			// Setting up the driver and calling objects and keywords from the different classes
			driver = new AppiumDriver(url, capabilities);
			objects = new ObjectStore(driver);
			CustomKeywords = new CustomKeywords(driver);
			
			// Documentation for the console
			System.out.println("\n -------- START OF TEST -------- \n");
						
			Thread.sleep(5000);
			
		} catch (Exception e) {
			// Prints errors if beforeMethod can't run
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void afterMethod() {
		// Documentation for the console
		System.out.println("\n -------- END OF TEST -------- \n");
		driver.quit();
	}

}
