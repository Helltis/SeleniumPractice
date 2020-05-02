package SeleTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IsElementPresetn {
    public static WebDriver driver;

    public static boolean isElementPresent(By by) {
		/*try {
		driver.findElement(By.xpath(locator));
		return true;
		}catch(Throwable t) {

			return false;
		}*/

        int size = driver.findElements(by).size();
        if(size==0) {

            return false;
        }else {

            return true;
        }
    }

    public static void main(String[] args) {



            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get("https://www.wikipedia.org/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


            System.out.println(isElementPresent(By.id("searchLanguage2334")));
    }
}
