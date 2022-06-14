package Project;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class activity6 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms/");
        driver.findElement(By.linkText("My Account")).click();
        String accountTitle = driver.getTitle();
        Assert.assertEquals(accountTitle,"My Account – Alchemy LMS");
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        List<WebElement> titleLsts = driver.findElements(By.cssSelector(".uagb-ifb-title"));
        for(WebElement title : titleLsts)
        {
            if(title.getText().equals("My Account"))
            {
                Assert.assertEquals(title.getText(),"My Account");
                driver.quit();
            }
        }
    }
}
