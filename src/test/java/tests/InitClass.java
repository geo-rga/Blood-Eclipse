package tests;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

//import org.openqa.selenium.remote.CapabilityType;
// Ensure that annotations always come from org.testng
import org.testng.annotations.*;
import io.appium.java_client.AppiumDriver;
import utils.AndroidCapabilities;
import utils.CustomKeywords;
//import utils.GlobalConfig;
import utils.IOSCapabilities;

public class InitClass {
	
	AppiumDriver driver;
	public ObjectStore objects;
	public CustomKeywords CustomKeywords;
	
	@BeforeMethod
	public void beforeMethod() {
		try {
			String configPlatform = System.getProperty("platform");
			System.out.println("Execution target platform: " + configPlatform);
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			if(configPlatform.equalsIgnoreCase("Android")) {
				capabilities = AndroidCapabilities.getCapabilities();
				
			} else if (configPlatform.equalsIgnoreCase("iOS")) {
				capabilities = IOSCapabilities.getCapabilities();
			} else {
				throw new IllegalArgumentException("Invalid platform: " + configPlatform);
			}
			
			URL url = new URL("http://127.0.0.1:4723/");
			
			driver = new AppiumDriver(url, capabilities);
			objects = new ObjectStore(driver);
			CustomKeywords = new CustomKeywords(driver);
			
			System.out.println("\n -------- START OF TEST -------- \n");
						
			Thread.sleep(5000);
			
		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("\n -------- END OF TEST -------- \n");
		driver.quit();
	}

}
