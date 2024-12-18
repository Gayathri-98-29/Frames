package testng;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class Selenium5 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Use WebDriverManager to automatically download and set up ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeOptions and maximize the window
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        // Create an instance of ChromeDriver
        driver = new ChromeDriver(options);
    }

    @Test
    public void testNextMonthAndSelectDate() {
        // Navigate to the Datepicker URL
        driver.get("https://jqueryui.com/datepicker/");

        // Switch to the iframe containing the Datepicker
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src='/resources/demos/datepicker/default.html']")));

        // Locate the datepicker input field and click it to open the calendar
        WebElement datepickerInput = driver.findElement(By.id("datepicker"));
        datepickerInput.click();

        // Click the 'Next' button to go to the next month
        WebElement nextButton = driver.findElement(By.cssSelector(".ui-datepicker-next"));
        nextButton.click();

        // Click on the '22' to select the 22nd day
        WebElement day22 = driver.findElement(By.xpath("//a[text()='22']"));
        day22.click();

        // Get the selected date from the input field
        String selectedDate = datepickerInput.getAttribute("value");

        // Print the selected date to the console
        System.out.println("Selected Date: " + selectedDate);
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser window
        if (driver != null) {
            driver.quit();
        }
    }
}
