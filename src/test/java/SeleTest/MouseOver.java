package SeleTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOver {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www2.hm.com/en_us/index.html");
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.cssSelector("li.menu__super:nth-child(3) > a:nth-child(1)"))).build().perform();
        driver.findElement(By.cssSelector("li.menu__super:nth-child(3) > ul:nth-child(4) > li:nth-child(5) > ul:nth-child(2) > li:nth-child(8) > a:nth-child(1)")).click();

    }
}
