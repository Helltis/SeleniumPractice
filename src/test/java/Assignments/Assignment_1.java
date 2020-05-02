package Assignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Assignment_1 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector(".gLFyf")).sendKeys("way2automation");
        driver.findElement(By.cssSelector(".FPdoLc > center:nth-child(1) > input:nth-child(1)")).click();
        driver.findElement(By.cssSelector("div.g:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > h3:nth-child(2)")).click();

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        for (WebElement link : links) {
            if (link.isDisplayed()) {
                System.out.println(link.getText());
            }
        }

        driver.close();
    }
}
