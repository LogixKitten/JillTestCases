package edu.tamut.tests;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Logout {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;

  @Before
  public void setUp() throws Exception {
    // Set the path for msedgedriver.exe
    System.setProperty("webdriver.edge.driver", "C:\\\\\\\\Users\\\\\\\\ethan\\\\\\\\OneDrive\\\\\\\\Documents\\\\\\\\edgedriver_win64\\\\\\\\msedgedriver.exe"); // Update with the actual path to msedgedriver.exe

    // Initialize EdgeDriver
    driver = new EdgeDriver();
    baseUrl = "https://www.google.com/";

    // Set timeouts
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    // Initialize JavaScript Executor
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testLogOut() throws Exception {
    // Navigate to the website
    driver.get("https://www.jillai.tech/");
    
    // Log in to the account
    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("Hamster");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("Mu2SW$16Y");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    
    // Click the dropdown menu
    driver.findElement(By.className("dropdown")).click();

    // Select an option from the dropdown menu
    WebElement dropdownMenu = driver.findElement(By.className("dropdown-menu"));
    List<WebElement> items = dropdownMenu.findElements(By.className("dropdown-item"));
    items.get(2).click(); // Select the third option (Logout)

    // Add a delay to observe behavior (optional)
    Thread.sleep(2000);
  }

  @After
  public void tearDown() throws Exception {
    // Quit the WebDriver
    if (driver != null) {
      driver.quit();
    }

    // Check for verification errors
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  // Helper method to check if an element is present
  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  // Helper method to check if an alert is present
  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  // Helper method to close an alert and retrieve its text
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
