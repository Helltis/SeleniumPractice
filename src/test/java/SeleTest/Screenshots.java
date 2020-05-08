package SeleTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class Screenshots {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www2.hm.com/en_us/index.html");
        Actions act = new Actions(driver);

        act.moveToElement(driver.findElement(By.xpath("//input[@id='main-search']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();

        //taking screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("/home/helltis/Pictures/hmscreen.png"));
        Thread.sleep(2000);

        driver.close();

    }
}
