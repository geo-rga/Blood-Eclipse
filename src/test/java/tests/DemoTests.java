package tests;

import org.testng.annotations.Test;

public class DemoTests extends InitClassJson {
	
	@Test
	public void AppLaunch_DefaultDisplay_7465() throws InterruptedException {
		/*
		 * -- Scenario --
		 * GIVEN I have just installed the application
		 * WHEN I open the application
		 * THEN I should see the landing page
		 * */
		assert CustomKeywords.validateDisplayed(objects.img_landingPage_arcLogo_locator);
		assert CustomKeywords.validateDisplayed(objects.t_landingPage_title_locator);
		assert CustomKeywords.validateDisplayed(objects.img_landingPage_image_locator);
		assert CustomKeywords.validateDisplayed(objects.btn_landingPage_scheduleNewAppt_locator);
		assert CustomKeywords.validateDisplayed(objects.btn_landingPage_createAccount_locator);
		assert CustomKeywords.validateDisplayed(objects.btn_landingPage_logIn_locator);
		assert CustomKeywords.validateDisplayed(objects.btn_landingPage_loginHelp_locator);
	}
	
	@Test
	public void AppLaunch_StartUpHelp_7469() throws InterruptedException {
		/*
		 * -- Scenario --
		 * GIVEN I am not logged into the application
		 * WHEN I tap the Log In Help link
		 * THEN I should see a content page 
		 * AND if I tap a container
		 * THEN I should be able to expand and collapse the information for each question
		 * */
		driver.findElement(objects.btn_landingPage_loginHelp_locator).click();
		Thread.sleep(2000);
		driver.findElement(objects.btn_startUpHelp_dropdown_locator).click();
		Thread.sleep(3000);
		assert CustomKeywords.validateDisplayed(objects.t_startUpHelp_dropdownContent_locator);
		Thread.sleep(2000);
		driver.findElement(objects.btn_startUpHelp_dropdown_locator).click();
		Thread.sleep(2000);
		assert CustomKeywords.validateNotDisplayed(objects.t_startUpHelp_dropdownContent_locator);
	}
	
	@Test
	public void Login_ValidInputs_7522() throws InterruptedException {
		/*
		 * -- Scenario --
		 * GIVEN I am on the login screen
		 * WHEN I enter valid login details
		 * THEN I should be logged into the app
		 * */
		driver.findElement(objects.btn_landingPage_logIn_locator).click();
		Thread.sleep(2000);
		driver.findElement(objects.i_loginScreen_usernameField_locator).sendKeys("DSUBATIS");
		driver.findElement(objects.i_loginScreen_passwordField_locator).sendKeys("Redcross1");
		Thread.sleep(2000);
		driver.findElement(objects.btn_loginScreen_continue_locator).click();
		Thread.sleep(8000);
		assert CustomKeywords.validateNotDisplayed(objects.t_loginScreen_welcomeBackTitle_locator);
		assert CustomKeywords.validateDisplayed(objects.t_biometricPermissions_permissionsTitle_locator);
	}
	
	

}