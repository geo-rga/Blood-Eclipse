package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.appium.java_client.MobileBy;

import org.openqa.selenium.By;

import java.io.InputStreamReader;

@SuppressWarnings("deprecation")
public class JsonReader {
	private static JsonObject jsonObjects;
	
	static {
		
		String jsonFile = "";

		// Setting JSON file to use for objects based on platform variable passed at runtime
		try {			
			if (System.getProperty("platform").equalsIgnoreCase("ANDROID")) {
		        jsonFile = "androidObjects.json";
		    } else if (System.getProperty("platform").equalsIgnoreCase("IOS")) {
		    	jsonFile = "iosObjects.json";
		    } 
		} catch (Exception e) {
			throw new RuntimeException("Failed to get platform from Capabilities");	
		}	
		
		// Use InputStreamReader to parse the objects file ready to get information
		try { 
			InputStreamReader reader = new InputStreamReader(
                    JsonReader.class.getClassLoader().getResourceAsStream(jsonFile)
            );
            jsonObjects = JsonParser.parseReader(reader).getAsJsonObject();
		} catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read objects JSON file");	
		}
	}
	

    public static By getLocator(String page, String element) {
    	// Search for specified object in parsed elements JSON, throw error if object does not exist
        if (!jsonObjects.has(page) || !jsonObjects.getAsJsonObject(page).has(element)) {
            throw new RuntimeException("Element not found in JSON: " + page + " -> " + element);
        }

        // Getting information for object 
        var locatorsArray = jsonObjects.getAsJsonObject(page)
                .getAsJsonObject(element)
                .getAsJsonArray("locators");

        // Default to first locator in the array
        var firstLocator = locatorsArray.get(0).getAsJsonObject();
        String type = firstLocator.get("type").getAsString();
        String value = firstLocator.get("value").getAsString();

        return getBy(type, value);
    }

    // Parsing locator based on value of type
	private static By getBy(String type, String value) {
        return switch (type.toLowerCase()) {
            case "xpath" -> By.xpath(value);
            case "css" -> By.cssSelector(value);
            case "id" -> By.id(value);
            case "accessibility id" -> MobileBy.accessibilityId(value);
            case "class" -> By.className(value);
            default -> throw new IllegalArgumentException("Unsupported locator type: " + type);
        };
    }
}
