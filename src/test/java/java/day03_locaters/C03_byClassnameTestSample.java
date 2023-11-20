package java.day03_locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import java.util.List;
import java.utilities.reusableMethods;

public class C03_byClassnameTestSample {
    // 1- Create a test class and configure the necessary settings.
    // 2- Go to https://www.automationexercise.com/.
    // 3- Locate the elements in the Category section.
    // 4- Test that there are 3 elements in the Category section.
    // 5- Print the names of the categories.
    // 6- Close the page.

    public static void main(String[] args) {

        // 1- Create a test class and configure the necessary settings.
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- Go to https://www.automationexercise.com/.
        driver.get("https://www.automationexercise.com/");

        // 3- Locate the elements in the Category section.
        List<WebElement> elementsOfCategory = driver.findElements(By.className("panel-title"));

        // 4- Test that there are 3 elements in the Category section.
        int expectedNumberOfElements = 3;
        int actualNumberOfElements = elementsOfCategory.size();

        if (expectedNumberOfElements == actualNumberOfElements){
            System.out.println("Number of elements test PASSED");
        }else{
            System.out.println("Number of elements test FAILED");
            System.out.println("Number of elements: " + actualNumberOfElements);
        }

        // 5- Print the names of the categories.
        System.out.println(reusableMethods.convertToStringList(elementsOfCategory));

        // 6- Close the page.
        driver.quit();










    }
}
