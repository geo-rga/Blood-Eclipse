package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class DemoTests extends AndroidBase {
	
	@Test
	public void android_AppLaunch_DefaultDisplay_7465() throws InterruptedException {
		
		assert validateDisplayed(objects.img_landingPage_arcLogo_locator);
		assert validateDisplayed(objects.t_landingPage_title_locator);
		assert validateDisplayed(objects.img_landingPage_image_locator);
		assert validateDisplayed(objects.btn_landingPage_scheduleNewAppt_locator);
		assert validateDisplayed(objects.btn_landingPage_createAccount_locator);
		assert validateDisplayed(objects.btn_landingPage_logIn_locator);
		assert validateDisplayed(objects.btn_landingPage_loginHelp_locator);
	}
	
	@Test
	public void android_AppLaunch_StartUpHelp_7469() throws InterruptedException {
		objects.btn_landingPage_loginHelp().click();
		Thread.sleep(2000);
		objects.btn_startUpHelp_dropdown().click();
		Thread.sleep(2000);
		assert validateDisplayed(objects.t_startUpHelp_dropdownContent_locator);
		objects.btn_startUpHelp_dropdown().click();
		Thread.sleep(2000);
		assert validateNotDisplayed(objects.t_startUpHelp_dropdownContent_locator);
	
	}
}


