package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("OnePlus 7T");
        options.setPlatformName("android");
        options.setAutomationName("UIAutomator2");
        options.setAppPackage("com.sec.android.app.popupcalculator");
        options.setAppActivity(".Calculator");
        options.noReset();

        URL serviceURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serviceURL, options);
    }

    @Test
    public void addition(){
        driver.findElement(AppiumBy.id("calc_keypad_btn_05")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_add")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_09")).click();
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal")).click();

        String text = driver.findElement(AppiumBy.id("calc_edt_formula")).getText();
        System.out.println("text is "+text);
        Assert.assertTrue(text.equalsIgnoreCase("14"), "Addition is not correct");
    }

    @Test
    public void subtraction(){
        driver.findElement(AppiumBy.id("calc_keypad_btn_01")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_00")).click();
        driver.findElement(AppiumBy.accessibilityId("Minus")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_05")).click();
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal")).click();

        String text = driver.findElement(AppiumBy.id("calc_edt_formula")).getText();
        System.out.println("text is "+text);
        Assert.assertTrue(text.equalsIgnoreCase("5"), "Subtraction is not correct");
    }

    @Test
    public void multiplication(){
        driver.findElement(AppiumBy.id("calc_keypad_btn_05")).click();
        driver.findElement(AppiumBy.accessibilityId("Multiplication")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_01")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_00")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_00")).click();

        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal")).click();

        String text = driver.findElement(AppiumBy.id("calc_edt_formula")).getText();
        System.out.println("text is "+text);
        Assert.assertTrue(text.equalsIgnoreCase("500"), "Multiplication is not correct");
    }

    @Test
    public void division(){
        driver.findElement(AppiumBy.id("calc_keypad_btn_05")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_00")).click();
        driver.findElement(AppiumBy.accessibilityId("Division")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_02")).click();
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal")).click();

        String text = driver.findElement(AppiumBy.id("calc_edt_formula")).getText();
        System.out.println("text is "+text);
        Assert.assertTrue(text.equalsIgnoreCase("25"), "Division is not correct");
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}