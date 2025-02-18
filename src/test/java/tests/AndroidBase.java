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
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.InteractsWithApps;

public class AndroidBase {
	
//	RemoteWebDriver driver;
	AppiumDriver driver;
	public AndroidVariableStore objects;
	
	@BeforeMethod
	public void setup() {	
		try {
			String appPath = System.getProperty("user.dir")+"/src/test/resources/apps/BloodStaging1957.apk";
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
//			capabilities.setCapability("appium:platformVersion", "14");
//			capabilities.setCapability("appium:deviceName", "Pixel 6");
//			capabilities.setCapability("appium:udid", "23091FDF6001DX");
			
			
			capabilities.setCapability("appium:platformVersion", "15");
			capabilities.setCapability("appium:deviceName", "Pixel 7");
			capabilities.setCapability("appium:udid", "32011FDH2003H8");
			
			capabilities.setCapability("appium:newCommandTimeout", 60);
			capabilities.setCapability("appium:automationName", "uiautomator2");
			capabilities.setCapability("appium:chromedriverAutodownload", true);
			capabilities.setCapability("appium:app", appPath);
			
			URL url = new URL("http://127.0.0.1:4723/");
			
			driver = new AppiumDriver(url, capabilities);
			objects = new AndroidVariableStore(driver);
			
			Thread.sleep(5000);
		
			
		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	@AfterMethod
	public void afterMethod() {
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

	
}
