package day03_locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_byLinkTest_byPartialLinkTest {
    // 1- Perform the necessary configurations.
    // 2- Go to the homepage of testotomasyonu.com.
    // 3- Click on the 'shoes' link.
    // 4- Test that the opened page's title contains 'shoes'.
    // 5- Test that the 'Shoes' link is also accessible on this page.

    public static void main(String[] args) {
        /// 1- Perform the necessary configurations.
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- Go to the homepage of testotomasyonu.com.
        driver.get("https://testotomasyonu.com");

        // 3- Click on the 'shoes' link.
        WebElement shoesLink = driver.findElement(By.linkText("Shoes"));
        shoesLink.click();

        /* If you use By.linkText(), you need to write the text on the link exactly as it is.
         If there are spaces, "?" or other characters, they must also be written exactly.
         If you want to search using only a part of the link, you can use By.partialLinkText(). */
        driver.findElement(By.partialLinkText("hoes")).click();

        // 4- Test that the opened page's title contains 'shoes'.
        if (driver.getTitle().contains("Shoes")){
            System.out.println("Title test PASSED");
        }else{
            System.out.println("Title test FAILED");
            System.out.println("Current title: " + driver.getTitle());
        }

        // 5- Test that the 'Shoes' link is also accessible on this page.
        driver.navigate().back();
        if (shoesLink.isEnabled()){
            System.out.println("Shoes link accessible test PASSED");
        }else{
            System.out.println("Shoes link accessible test FAILED");
        }




        driver.quit();
    }
}
