package java.day01_seleniumFirstAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_WebDriverCreation {
    public static void main(String[] args) throws InterruptedException {

        //We set properties of the webdriver
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://testotomasyonu.com");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.close();
    }
}
