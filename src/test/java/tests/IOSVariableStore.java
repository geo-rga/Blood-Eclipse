package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class IOSVariableStore {
	private AppiumDriver driver;
	
	public IOSVariableStore(AppiumDriver driver) {
		this.driver = driver;
	}
	// Locators
	public final By img_landingPage_arcLogo_locator = (By.xpath("//XCUIElementTypeImage[@name=\"arcLogo\"]"));
	public final By t_landingPage_title_locator = (By.xpath("//XCUIElementTypeStaticText[@name=\"Blood Donor\"]"));
	public final By img_landingPage_image_locator = (By.xpath("//XCUIElementTypeImage[@name=\"1599760456098_tymia\"]"));
	public final By btn_landingPage_scheduleNewAppt_locator = (By.xpath("//XCUIElementTypeButton[@name=\"SCHEDULE NEW APPOINTMENT\"]"));
	public final By btn_landingPage_createAccount_locator = (By.xpath("//XCUIElementTypeButton[@name=\"CREATE ACCOUNT\"]"));
	public final By btn_landingPage_logIn_locator = (By.xpath("//XCUIElementTypeButton[@name=\"LOG IN\"]"));
	public final By btn_landingPage_loginHelp_locator = (By.xpath("//XCUIElementTypeButton[@name=\"Help with Sign Up or Log In\"]"));
	public final By btn_startUpHelp_dropdown_locator = (By.xpath("//XCUIElementTypeApplication[@name=\"Blood Donor\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]"));
	public final By t_startUpHelp_dropdownContent_locator = (By.xpath("//XCUIElementTypeStaticText[@name=\"If you have an existing username & password for redcrossblood.org, you should choose ‘Log in’ from the Welcome Screen, and use those same credentials to log in to the app.  If you do not have a username/password specific to redcrossblood.org, even if you’re an existing donor, you must create one by selecting ‘Sign up’ on the Welcome Screen in order to use the app.\"]"));
	
	// Elements
	public WebElement img_landingPage_arcLogo() { return driver.findElement(img_landingPage_arcLogo_locator);}
	public WebElement t_landingPage_title() { return driver.findElement(t_landingPage_title_locator);}
	public WebElement img_landingPage_image() { return driver.findElement(img_landingPage_image_locator);}
	public WebElement btn_landingPage_scheduleNewAppt() { return driver.findElement(btn_landingPage_scheduleNewAppt_locator);}
	public WebElement btn_landingPage_createAccount() { return driver.findElement(btn_landingPage_createAccount_locator);}
	public WebElement btn_landingPage_logIn() { return driver.findElement(btn_landingPage_logIn_locator);}
	public WebElement btn_landingPage_loginHelp() { return driver.findElement(btn_landingPage_loginHelp_locator);}
	public WebElement btn_startUpHelp_dropdown() { return driver.findElement(btn_startUpHelp_dropdown_locator);}
	public WebElement t_startUpHelp_dropdownContent() { return driver.findElement(t_startUpHelp_dropdownContent_locator);}
}
