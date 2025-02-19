package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.appium.java_client.AppiumDriver;

import utils.JsonReader;

public class AndroidVariableStore {
	
	@SuppressWarnings("unused")
	private AppiumDriver driver;
	
	
	public AndroidVariableStore(AppiumDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	// Locators
	public final By img_landingPage_arcLogo_locator = JsonReader.getLocator("landingPage", "img_landingPage_arcLogo");
	public final By t_landingPage_title_locator = JsonReader.getLocator("landingPage", "t_landingPage_title");
	public final By img_landingPage_image_locator = JsonReader.getLocator("landingPage", "img_landingPage_image");
	public final By btn_landingPage_scheduleNewAppt_locator = JsonReader.getLocator("landingPage", "btn_landingPage_scheduleNewAppt");
	public final By btn_landingPage_createAccount_locator = JsonReader.getLocator("landingPage", "btn_landingPage_createAccount");
	public final By btn_landingPage_logIn_locator = JsonReader.getLocator("landingPage", "btn_landingPage_logIn");
	public final By btn_landingPage_loginHelp_locator = JsonReader.getLocator("landingPage", "btn_landingPage_loginHelp");
	public final By btn_startUpHelp_dropdown_locator = JsonReader.getLocator("startUpHelp", "btn_startUpHelp_dropdown");
	public final By t_startUpHelp_dropdownContent_locator = JsonReader.getLocator("startUpHelp", "t_startUpHelp_dropdownContent");
	
}
