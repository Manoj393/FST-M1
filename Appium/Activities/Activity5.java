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

public class Activity5 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Galaxy M51");
        options.setPlatformName("android");
        options.setAutomationName("UIAutomator2");
        options.setAppPackage("com.samsung.android.messaging");
        options.setAppActivity("com.android.mms.ui.ConversationComposer");
        options.noReset();

        URL serviceURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serviceURL, options);
    }

    @Test
    public void sendMessage() throws InterruptedException {
        driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc='Contacts, Tab 2 of 3']/android.widget.RelativeLayout/android.widget.TextView")).click();
        //WebElement msg = driver.findElement(AppiumBy.xpath("android.widget.TextView[@text='Messages']"));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Favourites header")));
        Thread.sleep(3000);

        WebElement msg = driver.findElement(AppiumBy.accessibilityId("Lavanya @ZenQ , Go to conversation"));
        msg.click();
        Thread.sleep(3000);

        driver.findElement(AppiumBy.id("com.samsung.android.messaging:id/message_edit_text")).sendKeys("Hello Aunt, GM");
        driver.findElement(AppiumBy.accessibilityId("Send")).click();
        Thread.sleep(3000);

        WebElement ele = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Hello Aunt, GM']"));

        Assert.assertTrue(ele.isDisplayed());
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }


}