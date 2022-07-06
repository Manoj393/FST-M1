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

public class googleTasks {
    AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("OnePlus 7T");
        options.setPlatformName("android");
        options.setAutomationName("UIAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        URL serviceURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serviceURL, options);
    }

    @Test
    public void tasks() throws InterruptedException {

        String task1 = "Complete Activity with Google Tasks";
        String task2 = "Complete Activity with Google Keep";
        String task3 = "Complete the second Activity Google Keep";

        //Adding task1
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        Thread.sleep(3000);

        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys(task1);
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        Thread.sleep(3000);

        //Adding task2
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        Thread.sleep(3000);

        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys(task2);
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        Thread.sleep(3000);

        //Adding task3
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        Thread.sleep(3000);

        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys(task3);
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        Thread.sleep(3000);

        List<WebElement> actualTasks = driver.findElements(AppiumBy.id("com.google.android.apps.tasks:id/task_name"));

        Assert.assertEquals(actualTasks.get(0).getText(), task3);
        Assert.assertEquals(actualTasks.get(1).getText(), task2);
        Assert.assertEquals(actualTasks.get(2).getText(), task1);

    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}