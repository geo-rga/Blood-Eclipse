package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.JsonReader;

public class ObjectStore {
	
	@SuppressWarnings("unused")
	private AppiumDriver driver;
	
	
	public ObjectStore(AppiumDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	// Landing Page
	public final By img_landingPage_arcLogo_locator = JsonReader.getLocator("landingPage", "img_landingPage_arcLogo");
	public final By t_landingPage_title_locator = JsonReader.getLocator("landingPage", "t_landingPage_title");
	public final By img_landingPage_image_locator = JsonReader.getLocator("landingPage", "img_landingPage_image");
	public final By btn_landingPage_scheduleNewAppt_locator = JsonReader.getLocator("landingPage", "btn_landingPage_scheduleNewAppt");
	public final By btn_landingPage_createAccount_locator = JsonReader.getLocator("landingPage", "btn_landingPage_createAccount");
	public final By btn_landingPage_logIn_locator = JsonReader.getLocator("landingPage", "btn_landingPage_logIn");
	public final By btn_landingPage_loginHelp_locator = JsonReader.getLocator("landingPage", "btn_landingPage_loginHelp");
	
	// Start Up Help
	public final By btn_startUpHelp_dropdown_locator = JsonReader.getLocator("startUpHelp", "btn_startUpHelp_dropdown");
	public final By t_startUpHelp_dropdownContent_locator = JsonReader.getLocator("startUpHelp", "t_startUpHelp_dropdownContent");
	
	// Log In
	public final By t_loginScreen_welcomeBackTitle_locator = JsonReader.getLocator("loginScreen", "t_loginScreen_welcomeBackTitle");
	public final By i_loginScreen_usernameField_locator = JsonReader.getLocator("loginScreen", "i_loginScreen_usernameField");
	public final By i_loginScreen_passwordField_locator = JsonReader.getLocator("loginScreen", "i_loginScreen_passwordField");
	public final By btn_loginScreen_continue_locator = JsonReader.getLocator("loginScreen", "btn_loginScreen_continue");
	public final By btn_loginScreen_forgotDetails_locator = JsonReader.getLocator("loginScreen", "btn_loginScreen_forgotDetails");
	
	// Biometric Screen
	public final By t_biometricPermissions_permissionsTitle_locator = JsonReader.getLocator("biometricPermissions", "t_biometricPermissions_permissionsTitle");
	public final By t_biometricPermissions_bulletOne_locator = JsonReader.getLocator("biometricPermissions", "t_biometricPermissions_bulletOne");
	public final By t_biometricPermissions_bulletTwo_locator = JsonReader.getLocator("biometricPermissions", "t_biometricPermissions_bulletTwo");
	public final By btn_biometricPermissions_enable_locator = JsonReader.getLocator("biometricPermissions", "btn_biometricPermissions_enable");
	public final By btn_biometricPermissions_notNow_locator = JsonReader.getLocator("biometricPermissions", "btn_biometricPermissions_notNow");
	
}
