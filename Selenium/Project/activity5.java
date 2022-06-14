package Project;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class activity5 {
    public static void main(String[] args)
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms/");
        driver.findElement(By.linkText("My Account")).click();
        String accountTitle = driver.getTitle();
        Assert.assertEquals(accountTitle,"My Account – Alchemy LMS");
        driver.quit();
    }
}

