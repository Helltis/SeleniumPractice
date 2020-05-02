package Assignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Assignment_3 {
    public static int answer;
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://timesofindia.indiatimes.com/poll.cms");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String capcha = driver.findElement(By.cssSelector("#mathq2")).getText();

        int one = Character.digit(capcha.charAt(0), 10);
        int two = Character.digit(capcha.charAt(4), 10);
        System.out.println(capcha + " " + answer);



        switch (capcha.charAt(2)) {
            case '+':
                answer = one + two;
                break;
            case '-':
                answer = one - two;
                break;
            case '/':
                answer = one / two;
                break;
            case '*':
                answer = one * two;
                break;
            default:
                System.out.println("F U");
        }

        String anwer2 = Integer.toString(answer);
        driver.findElement(By.cssSelector("#mathuserans2")).sendKeys(anwer2);

//        driver.close();


    }
}
