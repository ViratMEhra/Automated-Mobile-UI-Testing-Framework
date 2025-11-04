package com.mobile.base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class DriverManager {
    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            try {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("platformName", "Android");
                caps.setCapability("automationName", "UiAutomator2");
                caps.setCapability("deviceName", "Pixel_4_API_35");
                caps.setCapability("app", "C:\\Users\\hp\\Downloads\\DemoEcommerceApp.apk");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
                System.out.println("✅ Appium session started successfully!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
