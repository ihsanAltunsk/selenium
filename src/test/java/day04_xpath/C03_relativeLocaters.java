package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C03_relativeLocaters {
    // 1- Perform the necessary configurations.
    // 2- Go to https://testotomasyonu.com/relativeLocators.
    // 3- Locate the DSLR Camera element.
    // 4- Test that the 'src' tag in the WebElement's HTML code contains "testotomasyonu.com/uploads/product".
    // 5- Use the DSLR camera WebElement and relative locator to locate the Motor E13 phone.
    // 6- Test that the number 1688033137 is present in the src tag of the Motor E13 phone.

    public static void main(String[] args) {

        // 1- Perform the necessary configurations.
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- Go to https://testotomasyonu.com/relativeLocators.
        driver.get("https://testotomasyonu.com/relativeLocators");

        // 3- Locate the DSLR Camera element.
        WebElement dslrCameraElement = driver.findElement(By.id("pic7_thumb"));

        // 4- Test that the 'src' tag in the WebElement's HTML code contains "testotomasyonu.com/uploads/product".
        String srcAttributeValue = dslrCameraElement.getAttribute("src");
        String expectedHtmlContent ="testotomasyonu.com/uploads/product";
        if (srcAttributeValue.contains(expectedHtmlContent)){
            System.out.println("DSLR Camera test PASSED");
        }else{
            System.out.println("DSLR Camera test FAILED");
        }

        /*If you can see a WebElement on a web page, access its HTML code,
        but cannot locate it, with the help of surrounding WebElements, the locate operation can be performed.
        This is possible due to the introduction of the relative locator feature in Selenium 4.
        For a relative locator:
        -The target element must have at least 1 attribute.
        -There must be at least 1 other WebElement around the target element that we can locate and use.*/

        // 5- Use the DSLR camera WebElement and relative locator to locate the Motor E13 phone.
        WebElement motorE13Element =
                driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(dslrCameraElement));

        // 6- Test that the number 16882639136208024 is present in the src tag of the Motor E13 phone.
        expectedHtmlContent="16882639136208024";
        String actualSrcAttributeValue = motorE13Element.getAttribute("src");
        if (actualSrcAttributeValue.contains(expectedHtmlContent)){
            System.out.println("Motor E13 test PASSED");
        }else{
            System.out.println("Motor E13 test FAILED");
        }

        driver.quit();

    }
}
