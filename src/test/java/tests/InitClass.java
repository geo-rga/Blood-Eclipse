package tests;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
// Ensure that annotations always come from org.testng
import org.testng.annotations.*;
import io.appium.java_client.AppiumDriver;
import utils.TestConfig;

public class InitClass {
	
	AppiumDriver driver;
	public AndroidVariableStore androidObjects;
	public IOSVariableStore iosObjects;
	protected static String platformName;
	
	@BeforeMethod
	public void androidBeforeMethod() {	
		try {
			String appPath = System.getProperty("user.dir")+"/src/test/resources/apps/BloodStaging1957.apk";
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability("appium:platformVersion", "15");
			capabilities.setCapability("appium:deviceName", "Pixel 7");
			capabilities.setCapability("appium:udid", "32011FDH2003H8");
			
			capabilities.setCapability("appium:newCommandTimeout", 60);
			capabilities.setCapability("appium:automationName", "uiautomator2");
			capabilities.setCapability("appium:chromedriverAutodownload", true);
			capabilities.setCapability("appium:app", appPath);
			
			URL url = new URL("http://127.0.0.1:4723/");
			
			driver = new AppiumDriver(url, capabilities);
			androidObjects = new AndroidVariableStore(driver);
			
			platformName = capabilities.getCapability("platformName").toString();
			
			Thread.sleep(5000);
		
			
		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	@AfterMethod
	public void androidAfterMethod() {
		System.out.println("\n\n -------- END OF TEST -------- \n\n");
		driver.quit();
	}
	
	@BeforeMethod
	public void iosBeforeMethod() {	
		try {		
			
			String appPath = System.getProperty("user.dir")+"/src/test/resources/apps/BloodStaging2148.ipa";

			DesiredCapabilities capabilities = new DesiredCapabilities();
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
	

			URL url = new URL("http://127.0.0.1:4723/");
			
			driver = new AppiumDriver(url, capabilities);
			iosObjects = new IOSVariableStore(driver);
			
			platformName = capabilities.getCapability("platformName").toString();
			
			Thread.sleep(5000);
			
		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void iosAfterMethod() {
		System.out.println("\n\n -------- END OF TEST -------- \n\n");
		driver.quit();
	}
	
	boolean validateDisplayed(By loc) {
		String obj = loc.toString();
		try {
			WebElement el = driver.findElement(loc);
			System.out.println("Element "+obj+" displayed (expected)");
			return el.isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Element "+obj+" not displayed (fail)");
			return false;
		}
	}
	
	boolean validateNotDisplayed(By loc) {
		String obj = loc.toString();
		try {
			WebElement el = driver.findElement(loc);
			System.out.println("Element "+obj+" displayed (fail)");
			return !el.isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Element "+obj+" not displayed (expected)");
			return true;
		}
	}
	
	String platform() {
		return platformName;
		
	}

}
