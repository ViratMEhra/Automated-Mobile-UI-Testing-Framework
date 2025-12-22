package Automation;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Testttt {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setPlatformVersion("15");
        options.setDeviceName("Small Phone API 35");
        options.setAutomationName("UiAutomator2");
        options.setApp("C://Users//hp//Downloads//AndroidMyDemoAppRN.1.3.0.build244.apk");
        options.setNewCommandTimeout(Duration.ofSeconds(60000));

        //URL url = new URL("http://127.0.0.1:4723/");
        driver = new AndroidDriver(url, options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void testLoginFlow() {
        // Wait and click "Products"
        WebElement products = wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Products\")")
        ));
        products.click();
        System.out.println("Clicked Products");

        // Wait and click "Sauce Labs Backpack"
        WebElement backpack = wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Sauce Labs Backpack\")")
        ));
        backpack.click();
        System.out.println("Clicked Backpack");

        // Wait for Backpack image to be visible
        WebElement backpackImage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Sauce Labs Backpack\")")
        ));
        Assert.assertTrue(backpackImage.isDisplayed(), "Sauce Labs Backpack image is not displayed!");
        System.out.println("Backpack image displayed");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

