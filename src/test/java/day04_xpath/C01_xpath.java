package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_xpath {
    // 1- Go to https://testotomasyonu.com/addremove/.
    // 2- Click on the Add Element button.
    // 3- Test that the Remove button is visible.
    // 4- Click the Remove button.
    // 5- Test that the text "Add/Remove Elements" is visible.
    // 6- Test whether the remove button is not visible.

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- Go to https://testotomasyonu.com/addremove/.
        driver.get("https://testotomasyonu.com/addremove/");

        // 2- Click on the Add Element button.
        WebElement add = driver.findElement(By.xpath("//button[@id='sub-btn']"));
        add.click();

        // 3- Test that the Remove button is visible.
        WebElement remove = driver.findElement(By.xpath("//button[@class='remove-btn']"));
        if (remove.isDisplayed()){
            System.out.println("Remove button visibility test PASSED");
        }else{
            System.out.println("Remove button visibility test FAILED");
        }

        // 4- Click the Remove button.
        remove.click();

        // 5- Test that the text "Add/Remove Elements" is visible.
        WebElement addRemove = driver.findElement(By.xpath("//div[@class='container']"));
        if (addRemove.isDisplayed()){
            System.out.println("Add/Remove Elements visibility test PASSED");
        }else{
            System.out.println("Add/Remove Elements visibility test FAILED");
        }

        // 6- Test whether the remove button is not visible.
        try{
            driver.findElement(By.xpath("//button[@class='remove-btn']"));
            System.out.println("Remove button test FAILED");
        }catch (NoSuchElementException e){
            System.out.println("Remove button test PASSED");
        }

        driver.quit();
    }
}
