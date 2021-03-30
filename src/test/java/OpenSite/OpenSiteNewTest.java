package OpenSite;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import org.junit.Assert;
//import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.List;

public class OpenSiteNewTest {
    @Test
    public void testCTCO() throws Exception {
//     Launch webdriver
     System.setProperty("webdriver.gecko.driver","C://SRDEV//Tool//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        Thread.sleep(3000);
//      driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

//        1. Log into https://ctco.lv/en
        driver.get("https://ctco.lv/en");

//        2. Open Careers menu
//        3. Click Vacancies from the list.
//        4. Open vacancy with title "Mobile Test Engineer"
        driver.findElement(By.xpath("//a[@href='https://ctco.lv/careers/']")).click();
        driver.findElement(By.xpath("//div[@class='text-block']/h1[text()='Vacancies']")).click();
        driver.findElement(By.xpath("//*[text()='Mobile Test Engineer']")).click();

//        5. Verify that paragraph under Professional skills and qualification: contains exactly 6 skills.
        WebElement skill= driver
                .findElement(By.xpath("//div[@class='wysiwyg wysiwyg-2']/p[5]//em[text()='Professional skills and experience:']/following::ul[1]"));
        List<WebElement> skills = skill.findElements(By.tagName("li"));
        Integer count = skills.size();
        Assert.assertSame(count,6);
    }
}
