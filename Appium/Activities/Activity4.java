package activities;

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

public class Activity4 {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("OnePlus 7T");
        options.setPlatformName("android");
        options.setAutomationName("UIAutomator2");
        options.setAppPackage("com.samsung.android.app.contacts");
        options.setAppActivity("com.samsung.android.contacts.contactslist.PeopleActivity");
        options.noReset();

        URL serviceURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serviceURL, options);
    }

    @Test
    public void additionOfContact() throws InterruptedException {
        //clicking + icon to add contact
        driver.findElement(AppiumBy.accessibilityId("Create contact")).click();
        Thread.sleep(3000);

        //Name field to enter name
        driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/nameEdit")).sendKeys("mahesh kosuri");
        Thread.sleep(3000);

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Save']/android.view.ViewGroup/android.widget.TextView")).click();
        Thread.sleep(3000);

        WebElement ele = driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Edit contact']"));
        Assert.assertTrue(ele.isDisplayed());
    }


    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}