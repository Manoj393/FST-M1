package Project;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class activity9 {
    public static void main(String[] args)
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms/");
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        driver.findElement(By.linkText("All Courses")).click();
        List<WebElement> links = driver.findElements(By.linkText("See more..."));
        links.get(1).click();
        List<WebElement> options = driver.findElements(By.cssSelector(".ld-item-title"));
        for(WebElement option : options)
        {
            if(option.getText().contains("Improving & Designing Marketing Emails"))
            {
                option.click();
            }
        }
        Assert.assertEquals(driver.getTitle(),"Improving & Designing Marketing Emails – Alchemy LMS");
        List<WebElement> completeOptions = driver.findElements(By.xpath("//*[@value='Mark Complete']"));
        completeOptions.get(1).click();
        driver.quit();
    }
}
