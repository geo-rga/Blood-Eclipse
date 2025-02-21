package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Map;

public class ConfigReader {
	// Utility function for reading device config files for capabilities
    public static Map<String, String> readConfig(String filePath) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File(filePath), Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read config file: " + filePath, e);
        }
    }
}
