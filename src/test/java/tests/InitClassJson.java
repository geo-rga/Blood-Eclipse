package tests;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.Map;

// Ensure that annotations always come from org.testng
import org.testng.annotations.*;
import io.appium.java_client.AppiumDriver;
import utils.CustomKeywords;
import utils.DynamicCapabilities;
import utils.IOSCapabilities;
import utils.AndroidCapabilities;
import utils.ConfigReader;

public class InitClassJson {
	
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
				// Mapping from specific device config file
				capabilities = DynamicCapabilities.getCapabilities(System.getProperty("user.dir")+"/src/main/java/utils/android-device-config.json");
				
			} else if (configPlatform.equalsIgnoreCase("iOS")) {
				// Mapping from specific device config file
				capabilities = DynamicCapabilities.getCapabilities(System.getProperty("user.dir")+"/src/main/java/utils/ios-device-config.json");
				
			} else {
				// If platform variable isn't provided, exception here is thrown
				throw new IllegalArgumentException("Invalid platform: " + configPlatform);
			}
			
			// Setting up the driver and calling objects and keywords from the different classes
			driver = new AppiumDriver(new URL("http://127.0.0.1:4723/"), capabilities);
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
