package Project;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class activity1 {
    public static void main(String[] args)
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms/");
        System.out.println("Title of the lms page is :"+driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Alchemy LMS – An LMS Application");
        driver.quit();
    }
}