//DRIVERS CODE

package com.ecommerce.base;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URI;

public class DriverManager {

    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            try {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("platformName", "Android");
                caps.setCapability("automationName", "UiAutomator2");
                caps.setCapability("deviceName", "Pixel 2 API 35");
                caps.setCapability("app", "C:\\Users\\hp\\Downloads\\SauceLabsEcommerceApp.apk");

                URL serverUrl = URI.create("http://127.0.0.1:4723/").toURL();
;
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
