package utils;

public class TestConfig {
    private static String platformName;

    public static void setPlatformName(String platform) {
        platformName = platform;
        System.out.println("Platform set to "+platformName);
    }

    public static String getPlatformName() {
    	System.out.println("Running test on "+platformName+" device");
        return platformName;
    }

}
