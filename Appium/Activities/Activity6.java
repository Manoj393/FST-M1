package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Activity6 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Galaxy M51");
        options.setPlatformName("android");
        options.setAutomationName("UIAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        URL serviceURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serviceURL, options);
    }

    @Test
    public void openAndVerifyWebPage() throws InterruptedException {
        driver.get("https://www.training-support.net/selenium/lazy-loading");
        Thread.sleep(10000);

        String UIScrollable = "UiScrollable(UiSelector().scrollable(true))";
        Thread.sleep(5000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.Image")));

        List<WebElement> images = driver.findElements(AppiumBy.className("android.widget.Image"));
        System.out.println("Before scroll: " + images.size());

        driver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator(UIScrollable + ".scrollTextIntoView(\"helen\")"));

        images = driver.findElements(AppiumBy.className("android.widget.Image"));

        System.out.println("After scroll: " + images.size());

        // Assertions
        Assert.assertEquals(images.size(), 4);

    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}