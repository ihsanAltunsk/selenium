package java.day03_locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.utilities.reusableMethods;

public class C02_byClassnameLocater {
    public static void main(String[] args) {

        // 1- Go to the page "testotomasyonu.com"
        // 2- Type 'phone' in the search box and perform the search.
        // 3- After the search, test that the number of categories in the Categories menu on the left side is 8.
        // 4- Print the categories.

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- Go to the page "testotomasyonu.com"
        driver.get("https://testotomasyonu.com");

        /// 2- Type 'phone' in the search box and perform the search.
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone" + Keys.ENTER);

        // 3- After the search, test that the number of categories in the Categories menu on the left side is 8.
        List< WebElement> categoriesElementsList = driver.findElements(By.className("acc_head"));
        int expectedNumberOfCategories = 8;
        int actualNumberOfCategories = categoriesElementsList.size();

        if (expectedNumberOfCategories == actualNumberOfCategories){
            System.out.println("Category test PASSED");
        }else{
            System.out.println("Category test FAILED");
            System.out.println("Number of categories: " + actualNumberOfCategories);
        }

        // 4- Print the categories.
        System.out.println(categoriesElementsList);

        /* This list consists of web elements.
         We cannot directly print the text on web elements.
         We need to handle each web element individually and print its text.*/
        for (WebElement each : categoriesElementsList) {
            System.out.println(each.getText());
        }

        //We can handle this with the method we created in a shorter way.
        System.out.println(reusableMethods.convertToStringList(categoriesElementsList));

        driver.quit();


    }
}
