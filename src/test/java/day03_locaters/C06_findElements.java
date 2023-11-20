package day03_locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_findElements {
    // 1- Perform the necessary configurations.
    // 2- Go to testotomasyonu.com.
    // 3- Click on the 'shoes' link.
    // 4- Click on the 3rd product from the displayed items.
    // 5- Test that 'shoe' is mentioned in the short descriptions of the product case-insensitively.

    public static void main(String[] args) throws InterruptedException {
        // 1- Perform the necessary configurations.
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- Go to testotomasyonu.com.
        driver.get("https://www.testotomasyonu.com");

        // 3- Click on the 'shoes' link.
        driver.findElement(By.linkText("Shoes")).click();

        // 4- Click on the 3rd product from the displayed items.
        List<WebElement> produtcELementsList = driver.findElements(By.className("prod-img"));
        produtcELementsList.get(2).click();

        // 5- Test that 'shoe' is mentioned in the short descriptions of the product case-insensitively.
        WebElement productDetailsElement = driver.findElement(By.className("prod-detail"));
        String expectedDetail = "shoe";
        String actualDetail = productDetailsElement.getText().toLowerCase();

        if (actualDetail.contains(expectedDetail)){
            System.out.println("Product detail test PASSED");
        }else{
            System.out.println("Product detail test FAILED");
        }

        driver.quit();

    }
}
