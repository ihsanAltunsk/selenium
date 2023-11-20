package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_cssSelector {
    // 1- Go to the homepage of testotomasyonu.com
    // 2- Click on the electronics link
    // 3- In the sidebar, apply a filter with min 10, max 200 for the price
    // 4- Test that products are found in the search results
    // 5- Close the page

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- Go to the homepage of testotomasyonu.com
        driver.get("https://testotomasyonu.com");

        // 2- Click on the electronics link
        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();

        // 3- In the sidebar, apply a filter with min 10, max 200 for the price
        WebElement min = driver.findElement(By.cssSelector("input[class='form-control minPrice']"));
        WebElement max = driver.findElement(By.cssSelector("input[class='form-control maxPrice']"));
        min.clear();
        min.sendKeys("10");
        max.clear();
        max.sendKeys("200");
        driver.findElement(By.cssSelector("button[class='price-range-button']")).click();

        // 4- Test that products are found in the search results
        WebElement searchResultElement = driver.findElement(By.cssSelector(".product-count-text"));
        System.out.println(searchResultElement.getText());


    }
}
