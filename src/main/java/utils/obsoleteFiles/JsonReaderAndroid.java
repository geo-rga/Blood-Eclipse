package utils.obsoleteFiles;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
//import com.google.gson.stream.JsonReader;

import io.appium.java_client.MobileBy;

import org.openqa.selenium.By;

import java.io.InputStreamReader;

@SuppressWarnings("deprecation")
public class JsonReaderAndroid {
	private static JsonObject jsonObjects;
	
	static {
		
		try { 
			InputStreamReader reader = new InputStreamReader(
					JsonReaderAndroid.class.getClassLoader().getResourceAsStream("androidObjects.json")
            );
            jsonObjects = JsonParser.parseReader(reader).getAsJsonObject();
		} catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read objects JSON file");	
		}
	}
	

    public static By getLocator(String page, String element) {
        if (!jsonObjects.has(page) || !jsonObjects.getAsJsonObject(page).has(element)) {
            throw new RuntimeException("Element not found in JSON: " + page + " -> " + element);
        }

        var locatorsArray = jsonObjects.getAsJsonObject(page)
                .getAsJsonObject(element)
                .getAsJsonArray("locators");

        // Default to first locator in the array
        var firstLocator = locatorsArray.get(0).getAsJsonObject();
        String type = firstLocator.get("type").getAsString();
        String value = firstLocator.get("value").getAsString();

        return getBy(type, value);
    }

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
