package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.appium.java_client.AppiumDriver;

import utils.JsonReader;

public class AndroidVariableStore {
	
	private AppiumDriver driver;
	
	
	public AndroidVariableStore(AppiumDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	// Locators
	public final By img_landingPage_arcLogo_locator = JsonReader.getLocator("landingPage", "img_landingPage_arcLogo");
//	public final By img_landingPage_arcLogo_locator = By.id("com.cube.arc.blood:id/arc_logo");
	public final By t_landingPage_title_locator = By.id("com.cube.arc.blood:id/app_title");
	public final By img_landingPage_image_locator = By.id("com.cube.arc.blood:id/story_image");
	public final By btn_landingPage_scheduleNewAppt_locator = By.id("com.cube.arc.blood:id/schedule");
	public final By btn_landingPage_createAccount_locator = By.id("com.cube.arc.blood:id/sign_up");
	public final By btn_landingPage_logIn_locator = By.id("com.cube.arc.blood:id/log_in");
	public final By btn_landingPage_loginHelp_locator = By.id("com.cube.arc.blood:id/learn_more");
	public final By btn_startUpHelp_dropdown_locator = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.ImageView");
	public final By t_startUpHelp_dropdownContent_locator = By.id("com.cube.arc.blood:id/description");
	
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
