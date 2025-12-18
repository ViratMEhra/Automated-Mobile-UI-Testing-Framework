package Automation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.URL;
import java.time.Duration;

public class ETE_Test {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Android Device");
        options.setAutomationName("UiAutomator2");
        options.setApp("C:\\Users\\hp\\Downloads\\com-kapp-youtube-final-4288-63622377-55752288c5e69f78debf402153ae0812.apk");
        options.setNewCommandTimeout(Duration.ofSeconds(600));

        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AndroidDriver(url, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void testFlow() {
        WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.kapp.youtube.final:id/fab")));
        Add.click();
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.kapp.youtube.final:id/textInputEditText")));
        nextButton.sendKeys("Virat's Playlist");
        Assert.assertTrue(nextButton.isDisplayed());
        WebElement Add2=wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
        Add2.click();
        
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
