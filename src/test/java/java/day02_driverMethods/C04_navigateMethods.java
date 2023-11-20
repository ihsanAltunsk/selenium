package java.day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_navigateMethods {
    public static void main(String[] args) {

        // 1- Go to the page "testotomasyonu.com"
        // 2- Test that if the title contains "Otomasyon"
        // 3- Go to the page "youtube.com"
        // 4- Test that if the URL contains "youtube"
        // 5- Go back to the page "testotomasyonu.com"
        // 6- Test that if the URL contains "otomasyon"
        // 7- Close the page

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1- Go to the page "testotomasyonu.com"
        driver.get("https://testotomasyonu.com");

        // 2- Test that if the title contains "Otomasyon"
        String expectedTitle= "Otomasyon";
        String actualTitle= driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title test PASSED.");
        }else{
            System.out.println("Title test FAILED");
            System.out.println("Title: " + actualTitle);
        }

        // 3- Go to the page "youtube.com"
        driver.get("https://youtube.com");

        // 4- Test that if the URL contains "youtube"
        String expectedURL= "youtube";
        String actualURL= driver.getCurrentUrl();

        if (actualURL.contains(expectedURL)){
            System.out.println("URL test PASSED.");
        }else{
            System.out.println("URL test FAILED");
            System.out.println("URL: " + actualURL);
        }

        // 5- Go back to the page "testotomasyonu.com"
        driver.navigate().back();

        // 6- Test that if the URL contains "otomasyon"
        String expectedNewURL= "otomasyon";
        String actualNewURL= driver.getCurrentUrl();

        if (actualNewURL.contains(expectedNewURL)){
            System.out.println("URL test PASSED.");
        }else{
            System.out.println("URL test FAILED");
            System.out.println("URL: " + actualNewURL);
        }

        // 7- Close the page
        driver.quit();

    }
}
