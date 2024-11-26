package edu.tamut.tests;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.concurrent.TimeUnit;

public class PrivacyPolicy {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;  // Declare js here so it can be used throughout

  @Before
  public void setUp() throws Exception {
    // Ensure the correct path for msedgedriver.exe
    System.setProperty("webdriver.edge.driver", "C:\\Users\\ethan\\OneDrive\\Documents\\edgedriver_win64\\msedgedriver.exe");

    // Initialize EdgeDriver
    driver = new EdgeDriver();
    baseUrl = "https://www.google.com/";

    // Set timeouts
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void testPrivacyPolicy() throws Exception {
    driver.get("https://www.jillai.tech/");
    
    // Initialize JavascriptExecutor here
    js = (JavascriptExecutor) driver;

    // Scroll down the page
    js.executeScript("window.scrollBy(0, 2500)"); 
    Thread.sleep(5000); 
    // Find and click the "Privacy Policy" link
    driver.findElement(By.linkText("Privacy Policy")).click();
    Thread.sleep(3000);  // Wait for the page to load after scrolling

    
    // Optionally, check if the Privacy Policy page is loaded by checking the URL
    String currentUrl = driver.getCurrentUrl();
    assertTrue(currentUrl.contains("privacy_policy"));
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

  // Helper methods for handling alerts and elements (if needed)
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
