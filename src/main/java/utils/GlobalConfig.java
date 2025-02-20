package utils;

public class GlobalConfig {
    private static String platformName;

    public static void setPlatformName(String platform) {
        platformName = platform;
        System.out.println("Global variable platformName set to "+platformName);
    }

    public static String getPlatformName() {
//    	System.out.println("Running test on "+platformName+" device");
        return platformName;
    }

}
