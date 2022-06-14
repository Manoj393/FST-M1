package Project;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class activity2 {
    public static void main(String[] args)
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms/");
        String header = driver.findElement(By.xpath("//*[@class='uagb-ifb-title']")).getText();
        System.out.println("Header name is:"+header);
        Assert.assertEquals(header,"Learn from Industry Experts");
        driver.quit();
    }
}
