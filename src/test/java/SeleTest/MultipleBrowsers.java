package SeleTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;
import java.lang.Thread;

public class MultipleBrowsers {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;

        driver = new FirefoxDriver();
        clickAll(driver);

        driver = new ChromeDriver();
        clickAll(driver);
    }

    public static void driveSite(WebDriver driver) {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://google.com");
        driver.navigate().to("https://yahoo.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        driver.close();
    }

    public static void clickAll(WebDriver driver) throws InterruptedException {
        driver.get("https://hugoboss.com/us/");
        Thread wait = new Thread();

        WebElement footlinks = driver.findElement(By.xpath("/html/body/div[2]/footer/div[2]/div[2]/div[1]/ul"));
        System.out.println(footlinks.findElements(By.tagName("a")).size());

        for (int i = 0; i < footlinks.findElements(By.tagName("a")).size(); i++) {
            String clickontab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            footlinks.findElements(By.tagName("a")).get(i).sendKeys(clickontab);
            wait.sleep(1000);
        }
        driver.quit();
    }
}
