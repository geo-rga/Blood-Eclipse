package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.JsonReaderIOS;

public class IOSVariableStore {
	
	@SuppressWarnings("unused")
	private AppiumDriver driver;
	
	
	public IOSVariableStore(AppiumDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	// Locators
	public final By img_landingPage_arcLogo_locator = JsonReaderIOS.getLocator("landingPage", "img_landingPage_arcLogo");
	public final By t_landingPage_title_locator = JsonReaderIOS.getLocator("landingPage", "t_landingPage_title");
	public final By img_landingPage_image_locator = JsonReaderIOS.getLocator("landingPage", "img_landingPage_image");
	public final By btn_landingPage_scheduleNewAppt_locator = JsonReaderIOS.getLocator("landingPage", "btn_landingPage_scheduleNewAppt");
	public final By btn_landingPage_createAccount_locator = JsonReaderIOS.getLocator("landingPage", "btn_landingPage_createAccount");
	public final By btn_landingPage_logIn_locator = JsonReaderIOS.getLocator("landingPage", "btn_landingPage_logIn");
	public final By btn_landingPage_loginHelp_locator = JsonReaderIOS.getLocator("landingPage", "btn_landingPage_loginHelp");
	public final By btn_startUpHelp_dropdown_locator = JsonReaderIOS.getLocator("startUpHelp", "btn_startUpHelp_dropdown");
	public final By t_startUpHelp_dropdownContent_locator = JsonReaderIOS.getLocator("startUpHelp", "t_startUpHelp_dropdownContent");
	
}