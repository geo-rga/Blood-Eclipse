package utils;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidCapabilities {
	
	public static DesiredCapabilities getCapabilities() {
		DesiredCapabilities androidCapabilities = new DesiredCapabilities();
		androidCapabilities.setCapability(CapabilityType.PLATFORM_NAME, System.getProperty("platform"));
		androidCapabilities.setCapability("appium:platformVersion", "15");
		androidCapabilities.setCapability("appium:deviceName", "Pixel 7");
		androidCapabilities.setCapability("appium:udid", "32011FDH2003H8");
		androidCapabilities.setCapability("appium:app", System.getProperty("user.dir")+"/src/test/resources/apps/BloodStaging1957.apk");
		androidCapabilities.setCapability("appium:automationName", "uiautomator2");
		androidCapabilities.setCapability("appium:chromedriverAutodownload", true);
		androidCapabilities.setCapability("appium:newCommandTimeout", 60);
		androidCapabilities.setCapability("appium:fullReset", true);
		return androidCapabilities;
	}
}
