package edu.tamut.tests;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DeleteAccount {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;

  @Before
  public void setUp() throws Exception {
    // Ensure the correct path for msedgedriver.exe
    System.setProperty("webdriver.edge.driver", "C:\\\\Users\\\\ethan\\\\OneDrive\\\\Documents\\\\edgedriver_win64\\\\msedgedriver.exe"); // Replace with the path to msedgedriver

    // Initialize EdgeDriver
    driver = new EdgeDriver();
    baseUrl = "https://www.google.com/";
    
    // Set timeouts
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    
    // Initialize JavaScript Executor
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testAccountSettings() throws Exception {
    // Test login functionality
    driver.get("https://www.jillai.tech/");
    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("Test2");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("Password1!");
    driver.findElement(By.xpath("//button[@type='submit']")).click();

    // Open the dropdown menu
    driver.findElement(By.className("dropdown")).click();

    // Select an option
    WebElement dropdownMenu = driver.findElement(By.className("dropdown-menu"));
    List<WebElement> items = dropdownMenu.findElements(By.className("dropdown-item"));
    items.get(1).click();

    
    
   
    driver.get("https://www.jillai.tech/dashboard");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Confirm'])[1]/following::h1[1]")).click();
    driver.findElement(By.xpath("//img[contains(@src,'https://api.dicebear.com/9.x/initials/svg?seed=Test%20Test')]")).click();
    driver.findElement(By.linkText("Account Settings")).click();
    driver.get("https://www.jillai.tech/account_settings");
    
    // Scroll down to the bottom of the page
    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

    // Add a delay so you can see the scroll (optional)
    try {
        Thread.sleep(2000);  // wait for 2 seconds
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Submit Changes'])[1]/following::button[1]")).click();
    driver.findElement(By.xpath("//div[@id='modal-delete-account']/div/div/div[3]/form/button")).click();
    driver.get("https://www.jillai.tech/");
    
    // Scroll back to the top
    js.executeScript("window.scrollTo(0, 0);");
    
    // Add a delay so you can see the scroll (optional)
    try {
        Thread.sleep(2000);  // wait for 2 seconds
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    Thread.sleep(2000);
  }

  @After
  public void tearDown() throws Exception {
    // Quit the driver
    if (driver != null) {
      driver.quit();
    }
    
    // Handle verification errors
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  // Helper methods
  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
