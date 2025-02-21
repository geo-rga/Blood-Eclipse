package utils;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IOSCapabilities {
	
	public static DesiredCapabilities getCapabilities() {
		// Properties required to run tests on an iOS real device. Also set up in ios-device-config.json file
		DesiredCapabilities iosCapabilities = new DesiredCapabilities();
		iosCapabilities.setCapability(CapabilityType.PLATFORM_NAME, System.getProperty("platform"));
		iosCapabilities.setCapability("appium:platformVersion", "18.1");
		iosCapabilities.setCapability("appium:deviceName", "GT - iPhone 11 (18.1)");
		iosCapabilities.setCapability("appium:udid", "00008030-000A31C134C0802E");
		iosCapabilities.setCapability("appium:automationName", "XCUITest");
		iosCapabilities.setCapability("appium:app", System.getProperty("user.dir")+"/src/test/resources/apps/BloodStaging2148.ipa");
		iosCapabilities.setCapability("appium:xcodeOrgId", "25H7BM6YWK");
		iosCapabilities.setCapability("appium:xcodeSigningId", "iPhone Developer");
		iosCapabilities.setCapability("appium:updatedWDABundleId", "com.facebook.WebDriverAgentRunner.xctrunner");
		iosCapabilities.setCapability("appium:newCommandTimeout", 60);
		return iosCapabilities;
		
	}

}