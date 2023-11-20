package day03_locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_webElementMethods {
    // 1- Create a test class and make the necessary configurations.
    // 2- Go to https://www.automationexercise.com/.
    // 3- Test that there are 147 links on the page.
    // 4- Click on the Products link.
    // 5- Test that the 'special offer' text is visible.
    // 6- Close the page.

    public static void main(String[] args) {

        // 1- Create a test class and make the necessary configurations.
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- Go to https://www.automationexercise.com/.
        driver.get("https://www.automationexercise.com/");

        // 3- Test that there are 147 links on the page.
        List<WebElement> linkElementLinks = driver.findElements(By.tagName("a"));
        int expectedNumberOfLinks = 147;
        int actualNumberOfLinks = linkElementLinks.size();

        if (actualNumberOfLinks == expectedNumberOfLinks){
            System.out.println("Number of links test PASSED");
        }else{
            System.out.println("Number of links test FAILED");
            System.out.println("Number of links: " + actualNumberOfLinks);
        }

        // 4- Click on the Products link.
        driver.findElement(By.partialLinkText("Products")).click();

        // 5- Test that the 'special offer' text is visible.
        WebElement specialOfferElement = driver.findElement(By.id("sale_image"));
        if (specialOfferElement.isDisplayed()){
            System.out.println("Special offer element test PASSED");

        }else{
            System.out.println("Special offer element test FAILED");
        }

        // 6- Close the page.
        driver.quit();
    }
}
