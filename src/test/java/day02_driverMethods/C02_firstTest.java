package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_firstTest {
    // 1- Go to the page "testotomasyonu.com"
    // 2- Test that; the URL contains "https://www.testotomasyonu.com"
    // 3- and the title contains the word 'test' in it

    public static void main(String[] args) throws InterruptedException {

        //we should create and configure a webdriver for each test we perform
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1- Go to the page "testotomasyonu.com"
        driver.get("https://www.testotomasyonu.com");

        // 2- Is the URL contains "https://testotomasyonu.com"
        String expectedURL = "https://www.testotomasyonu.com";
        String actualURL = driver.getCurrentUrl();

        if (expectedURL.equals(actualURL)){
            System.out.println("URL test PASSED.");
        }else {
            System.out.println("URL test FAILED.");
            System.out.println("actual URL: " + actualURL);
        }

        // 3- Is the title contains the word 'test' in it
        String expectedTitle = "test";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(actualTitle)){
            System.out.println("Title test PASSED.");
        }else {
            System.out.println("Title test FAILED. ");
            System.out.println("Title: " + actualTitle);
        }
        driver.quit();
    }
}
