package SeleTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

public class HandlingAlerts {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions ops = new FirefoxOptions();
        ops.addArguments("--disable-notifications");
        WebDriver driver = new FirefoxDriver(ops);


        ignoreNots(driver);
    }

    public static void javasrcAll(WebDriver driver) {
        driver.get("http://tizag.com/javascriptT/javascriptalert.php");
        driver.findElement(By.cssSelector(".display > form:nth-child(1) > input:nth-child(1)")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        driver.close();
    }

    public static void ignoreNots(WebDriver driver) {
        driver.get("https://www.flyuia.com/ua/en/information/lowest-airfare-calendar");
        WebElement dropdown = driver.findElement(By.xpath("/html/body/main/div/section[2]/div/div[1]/div[1]/span/div/select"));
        Select sel = new Select(dropdown);
        sel.selectByValue("Dnipro");

    }
}
