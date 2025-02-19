package utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.By;

import java.io.InputStreamReader;

public class JsonReader {
	private static JsonObject jsonObjects;
	
	static {
		
		String jsonFile = "";
		
		if (TestConfig.getPlatformName().equalsIgnoreCase("Android")) {
	        jsonFile = "androidObjects.json";
	    } else if (TestConfig.getPlatformName().equalsIgnoreCase("iOS")) {
	    	jsonFile = "iosObjects.json";
	    }
		
		try { 
			InputStreamReader reader = new InputStreamReader(
                    JsonReader.class.getClassLoader().getResourceAsStream(jsonFile)
            );
            jsonObjects = JsonParser.parseReader(reader).getAsJsonObject();
		} catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read androidObjects.json");	
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
            case "class" -> By.className(value);
            default -> throw new IllegalArgumentException("Unsupported locator type: " + type);
        };
    }
}
