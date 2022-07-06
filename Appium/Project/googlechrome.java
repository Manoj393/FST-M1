package project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class googleChrome {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("OnePlus 7T");
        options.setPlatformName("android");
        options.setAutomationName("UIAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        URL serviceURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serviceURL, options);
    }

    @Test
    public void chromeTest() throws InterruptedException {
        driver.get("https://www.training-support.net/selenium");
        Thread.sleep(3000);

        String UIScrollable = "UiScrollable(UiSelector().scrollable(true))";

        driver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator(UIScrollable + ".scrollTextIntoView(\"To-Do List\")")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement task = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"));
        WebElement addTaskBtn = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']"));


        task.click();
        task.sendKeys("Add tasks to list");
        addTaskBtn.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        task.click();
        task.sendKeys("Get number of tasks");
        addTaskBtn.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        task.click();
        task.sendKeys("Clear the list");
        addTaskBtn.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        List<WebElement> noOfListItems = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View/android.widget.TextView"));
        int noOfTasks = noOfListItems.size() - 1;
        System.out.println ("No. of Tasks : "+noOfTasks);

        //Strike out
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Add tasks to list']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Get number of tasks']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Clear the list']")).click();

        // Clear tasks list
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Assert
        noOfListItems = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View/android.widget.TextView"));
        noOfTasks = noOfListItems.size();
        System.out.println ("No. of Tasks after clearing list : " +noOfTasks);
        Assert.assertEquals(noOfTasks,0);





    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}