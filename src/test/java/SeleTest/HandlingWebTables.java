package SeleTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class HandlingWebTables {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        Logger tableContent = LogManager.getLogger();

        driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
        List<WebElement> stockTable = driver.findElements(By.xpath("/html/body/div[2]/div[5]/table/tbody/tr"));

        for (int i = 1; i < stockTable.size(); i++) {
            tableContent.info(stockTable.get(i).getText());
        }

        driver.quit();

    }
}
