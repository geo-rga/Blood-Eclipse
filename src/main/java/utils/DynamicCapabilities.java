package utils;

import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;

public class DynamicCapabilities {
	
	// Reusable function to run based on execution platform
	public static DesiredCapabilities getCapabilities(String appFilePath) {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		
		// Getting JSON file
		Map<String, Object> aDeviceConfig = ConfigReader.readConfig(appFilePath);
		
		// Mapping to array, and appending user directory path to app file path as this variable cannot be set on the JSON
		for (Map.Entry<String, Object> entry : aDeviceConfig.entrySet()) {
			Object value = entry.getValue();
            String key = entry.getKey();
			
			if ("app".equals(key)) {
				String relativePath = (String) value;
				String absolutePath = System.getProperty("user.dir")+relativePath;
				caps.setCapability(key, absolutePath);
					
			} else {
				// Dynamically setting each property (key, value) from the config to capabilities
				caps.setCapability(entry.getKey(), entry.getValue());
				
			}
        }
		
		return caps;
		
	}

}
