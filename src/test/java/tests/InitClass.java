package tests;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
// Ensure that annotations always come from org.testng
import org.testng.annotations.*;
import io.appium.java_client.AppiumDriver;
import utils.CustomKeywords;
import utils.GlobalConfig;

public class InitClass {
	
	AppiumDriver driver;
	public ObjectStore objects;
	public CustomKeywords CustomKeywords;
	
	@BeforeMethod
	public void beforeMethod() {
		try {
			String configPlatform = System.getProperty("platform");
			System.out.println("Config platform: " + configPlatform);
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			if(configPlatform.equalsIgnoreCase("Android")) {
				String appPath = System.getProperty("user.dir")+"/src/test/resources/apps/BloodStaging1957.apk";
				capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
				capabilities.setCapability("appium:platformVersion", "15");
				capabilities.setCapability("appium:deviceName", "Pixel 7");
				capabilities.setCapability("appium:udid", "32011FDH2003H8");
				capabilities.setCapability("appium:newCommandTimeout", 60);
				capabilities.setCapability("appium:automationName", "uiautomator2");
				capabilities.setCapability("appium:chromedriverAutodownload", true);
				capabilities.setCapability("appium:app", appPath);
			} else if (configPlatform.equalsIgnoreCase("iOS")) {
				String appPath = System.getProperty("user.dir")+"/src/test/resources/apps/BloodStaging2148.ipa";
				capabilities.setCapability(CapabilityType.PLATFORM_NAME, "ios");
				capabilities.setCapability("appium:platformVersion", "18.1");
				capabilities.setCapability("appium:deviceName", "GT - iPhone 11 (18.1)");
				capabilities.setCapability("appium:udid", "00008030-000A31C134C0802E");
				capabilities.setCapability("appium:newCommandTimeout", 60);
				capabilities.setCapability("appium:automationName", "XCUITest");
				capabilities.setCapability("appium:app", appPath);
				capabilities.setCapability("appium:xcodeOrgId", "25H7BM6YWK");
				capabilities.setCapability("appium:xcodeSigningId", "iPhone Developer");
				capabilities.setCapability("appium:updatedWDABundleId", "com.facebook.WebDriverAgentRunner.xctrunner");
			} else {
				throw new IllegalArgumentException("Invalid platform: " + configPlatform);
			}

			URL url = new URL("http://127.0.0.1:4723/");
			
			String platformName = capabilities.getCapability("platformName").toString();
			GlobalConfig.setPlatformName(platformName);
			
			driver = new AppiumDriver(url, capabilities);
			objects = new ObjectStore(driver);
			CustomKeywords = new CustomKeywords(driver);
						
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
