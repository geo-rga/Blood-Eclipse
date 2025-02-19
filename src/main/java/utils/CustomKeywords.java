package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CustomKeywords {
	
//	boolean validateDisplayed(By loc) {
//		String obj = loc.toString();
//		try {
//			WebElement el = driver.findElement(loc);
//			System.out.println("Element "+obj+" displayed (expected)");
//			return el.isDisplayed();
//		} catch (NoSuchElementException e) {
//			System.out.println("Element "+obj+" not displayed (fail)");
//			return false;
//		}
//	}
//	
//	boolean validateNotDisplayed(By loc) {
//		String obj = loc.toString();
//		try {
//			WebElement el = driver.findElement(loc);
//			System.out.println("Element "+obj+" displayed (fail)");
//			return !el.isDisplayed();
//		} catch (NoSuchElementException e) {
//			System.out.println("Element "+obj+" not displayed (expected)");
//			return true;
//		}
//	}

}
