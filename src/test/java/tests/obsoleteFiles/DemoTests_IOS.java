package tests.obsoleteFiles;

import org.testng.annotations.*;

public class DemoTests_IOS extends IOSBase {
	@Test
	public void iOS_AppLaunch_DefaultDisplay_7465() throws InterruptedException {
		
		assert validateDisplayed(objects.img_landingPage_arcLogo_locator);
		assert validateDisplayed(objects.t_landingPage_title_locator);
		assert validateDisplayed(objects.img_landingPage_image_locator);
		assert validateDisplayed(objects.btn_landingPage_scheduleNewAppt_locator);
		assert validateDisplayed(objects.btn_landingPage_createAccount_locator);
		assert validateDisplayed(objects.btn_landingPage_logIn_locator);
		assert validateDisplayed(objects.btn_landingPage_loginHelp_locator);
		
	}
	
	@Test
	public void iOS_AppLaunch_StartUpHelp_7469() throws InterruptedException {
		driver.findElement(objects.btn_landingPage_loginHelp_locator).click();
		Thread.sleep(2000);
		driver.findElement(objects.btn_startUpHelp_dropdown_locator).click();
		Thread.sleep(3000);
		assert validateDisplayed(objects.t_startUpHelp_dropdownContent_locator);
		Thread.sleep(2000);
		driver.findElement(objects.btn_startUpHelp_dropdown_locator).click();
		Thread.sleep(2000);
		assert validateNotDisplayed(objects.t_startUpHelp_dropdownContent_locator);
	
	}
	

}
