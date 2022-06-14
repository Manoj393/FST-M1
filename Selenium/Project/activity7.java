package Project;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class activity7 {
    public static void main(String[] args)
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms/");
        driver.findElement(By.linkText("All Courses")).click();
        List<WebElement> courseLst = driver.findElements(By.xpath("//*[@class='caption']//h3"));
        for(WebElement course:courseLst)
        {
            System.out.println(course.getText());
        }
        driver.quit();
    }
}
