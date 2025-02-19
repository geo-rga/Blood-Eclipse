package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import utils.TestConfig;

public class DemoTests extends InitClass {
	
	
	
	@Test
	public void AppLaunch_DefaultDisplay_7465() throws InterruptedException {
		String platform = platform();
		if( platform == "ANDROID" ) {
			assert validateDisplayed(androidObjects.img_landingPage_arcLogo_locator);
			assert validateDisplayed(androidObjects.t_landingPage_title_locator);
			assert validateDisplayed(androidObjects.img_landingPage_image_locator);
			assert validateDisplayed(androidObjects.btn_landingPage_scheduleNewAppt_locator);
			assert validateDisplayed(androidObjects.btn_landingPage_createAccount_locator);
			assert validateDisplayed(androidObjects.btn_landingPage_logIn_locator);
			assert validateDisplayed(androidObjects.btn_landingPage_loginHelp_locator);
			
		} else if ( platform == "IOS") {
			assert validateDisplayed(iosObjects.img_landingPage_arcLogo_locator);
			assert validateDisplayed(iosObjects.t_landingPage_title_locator);
			assert validateDisplayed(iosObjects.img_landingPage_image_locator);
			assert validateDisplayed(iosObjects.btn_landingPage_scheduleNewAppt_locator);
			assert validateDisplayed(iosObjects.btn_landingPage_createAccount_locator);
			assert validateDisplayed(iosObjects.btn_landingPage_logIn_locator);
			assert validateDisplayed(iosObjects.btn_landingPage_loginHelp_locator);
		}
	
	}
	
//	@Test
//	public void AppLaunch_StartUpHelp_7469() throws InterruptedException {
//		driver.findElement(objects.btn_landingPage_loginHelp_locator).click();
//		Thread.sleep(2000);
//		driver.findElement(objects.btn_startUpHelp_dropdown_locator).click();
//		Thread.sleep(2000);
//		assert validateDisplayed(objects.t_startUpHelp_dropdownContent_locator);
//		driver.findElement(objects.btn_startUpHelp_dropdown_locator).click();
//		Thread.sleep(2000);
//		assert validateNotDisplayed(objects.t_startUpHelp_dropdownContent_locator);
//	
//	}

}
