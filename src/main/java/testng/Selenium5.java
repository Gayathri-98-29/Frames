package testng;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Selenium5 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to your WebDriver executable (Chromedriver)
    	  WebDriverManager.chromedriver().setup();

          // Initialize ChromeOptions and maximize the window
          ChromeOptions options = new ChromeOptions();
          options.addArguments("--start-maximized");

          // Create an instance of ChromeDriver
          driver = new ChromeDriver(options);
    }

    @Test
    public void testSignUpAndLogin() {
        try {
            // Step 1: Sign Up
            driver.get("https://www.guvi.in/signup");  // Replace with the Guvi sign-up URL

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Set up explicit wait

            // Wait for the "username" field to be visible
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));  // Replace with actual element
            usernameField.sendKeys("testuser");

            // Wait for the "email" field to be visible
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));  // Replace with actual element
            emailField.sendKeys("testuser@example.com");

            // Wait for the "password" field to be visible
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));  // Replace with actual element
            passwordField.sendKeys("Password123");

            // Wait until the sign-up button is clickable
            WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));  // Replace with actual element
            signUpButton.click();

            // Assertion to confirm the sign-up was successful
            WebElement signUpSuccessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success-message")));  // Replace with actual element
            Assert.assertTrue(signUpSuccessMessage.isDisplayed(), "Sign up failed!");

            // Step 2: Login
            driver.get("https://www.guvi.in/login");  // Replace with the Guvi login URL

            // Wait for the email field to be visible for login
            WebElement emailFieldLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));  // Replace with actual element
            emailFieldLogin.sendKeys("testuser@example.com");

            // Wait for the password field to be visible for login
            WebElement passwordFieldLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));  // Replace with actual element
            passwordFieldLogin.sendKeys("Password123");

            // Wait for the login button to be clickable
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));  // Replace with actual element
            loginButton.click();

            // Assertion to confirm login was successful
            WebElement profileIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile-icon")));  // Replace with actual element
            Assert.assertTrue(profileIcon.isDisplayed(), "Login failed!");
        } catch (TimeoutException e) {
            System.out.println("Timeout exception occurred. Ensure the page elements are loaded correctly.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An error occurred during the test.");
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
