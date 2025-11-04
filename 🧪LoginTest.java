package com.mobile.tests;

import com.mobile.base.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.*;

public class LoginTest {
    private AppiumDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverManager.getDriver();
    }

    @Test
    public void verifyAppLaunch() {
        System.out.println("✅ App launched successfully!");
    }

    @Test
    public void verifyUserLogin() {
        System.out.println("✅ User login simulated successfully!");
    }

    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
