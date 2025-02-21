package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class CustomKeywords {
	private AppiumDriver driver;
	
	public CustomKeywords(AppiumDriver driver) {
		this.driver = driver;
	}
	
	public boolean validateDisplayed(By loc) {
		// Custom function for checking if an element is displayed on screen, and outputting additional logging if the object is displayed or not
		String obj = loc.toString();
		try {
			WebElement el = driver.findElement(loc);
			System.out.println("Element "+obj+" displayed (expected)");
			return el.isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Element "+obj+" not displayed (fail)");
			return false;
		}
	}
	
	public boolean validateNotDisplayed(By loc) {
		// Custom function for checking if an element is not displayed on screen, and outputting additional logging if the object is displayed or not
		String obj = loc.toString();
		try {
			WebElement el = driver.findElement(loc);
			System.out.println("Element "+obj+" displayed (fail)");
			return !el.isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Element "+obj+" not displayed (expected)");
			return true;
		}
	}
}
