package java.day02_driverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_manageMethods {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // The implicitlyWait() is the dynamically defined maximum waiting time
        // for the page to load and/or to find the web elements we are searching for.

        // Its primary purpose, however, is not to wait but to fulfill its task.

        // The duration defined here is the maximum time it will attempt to perform its task.
        // If it cannot complete the task within this time frame, it throws an exception.

        System.out.println("First position: " + driver.manage().window().getPosition());
        System.out.println("First size: " + driver.manage().window().getSize());

        driver.manage().window().maximize();
        System.out.println("Max position: " + driver.manage().window().getPosition());
        System.out.println("Max size: " + driver.manage().window().getSize());

        driver.manage().window().fullscreen();
        System.out.println("Fullscreen position: " + driver.manage().window().getPosition());
        System.out.println("Fullscreen size: " + driver.manage().window().getSize());

        //Set the window to the starting point (50,100) with a size of (1000,700).
        driver.manage().window().setPosition(new Point(50,100));
        driver.manage().window().setSize(new Dimension(1000,700));
        System.out.println("Special position: " + driver.manage().window().getPosition());
        System.out.println("Special size: " + driver.manage().window().getSize());

        driver.quit();
    }
}
