package project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class googleKeep {
    AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("OnePlus 7T");
        options.setPlatformName("android");
        options.setAutomationName("UIAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        URL serviceURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serviceURL, options);
    }

    @Test
    public void keepNotes() throws InterruptedException {

        String title = "FST Notes";
        String desc = "FST Notes for Google Keep";

        //Adding Notes
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();
        Thread.sleep(3000);

        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys(desc);
        Thread.sleep(2000);

        driver.findElement(AppiumBy.id("com.google.android.keep:id/browse_text_note")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.id("editable_title")).sendKeys(title);

        Thread.sleep(3000);

        //Clicking back button
        driver.findElement(AppiumBy.accessibilityId("Open navigation drawer")).click();
        Thread.sleep(3000);

        List<WebElement> actualNoteTitle = driver.findElements(AppiumBy.id("com.google.android.keep:id/index_note_title"));
        List<WebElement> actualNoteDesc = driver.findElements(AppiumBy.id("com.google.android.keep:id/index_note_text_description"));

        Assert.assertEquals(actualNoteTitle.get(0).getText(), title);
        Assert.assertEquals(actualNoteDesc.get(0).getText(), desc);
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}