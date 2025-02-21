package utils;

public class GlobalConfig {
	
	// Android config
	public final static String androidPath = System.getProperty("user.dir")+"/src/test/resources/apps/BloodStaging1957.apk";
	public final static String androidDeviceName = "Pixel 7";
	public final static String androidUDID = "32011FDH2003H8";
	public final static String androidVersion = "15";
	public final static String androidAutomationName = "uiautomator2";
	
	// iOS config
	public final static String iosPath = System.getProperty("user.dir")+"/src/test/resources/apps/BloodStaging2148.ipa";
	public final static String iosDeviceName = "GT - iPhone 11 (18.1)";
	public final static String iosUDID = "00008030-000A31C134C0802E";
	public final static String iosVersion = "18.1";
	public final static String xcodeOrgId = "25H7BM6YWK";
	public final static String xcodeSigningId = "iPhone Developer";
	public final static String updatedWDABundleId = "com.facebook.WebDriverAgentRunner.xctrunner";
	public final static String iosAutomationName = "XCUITest";

}