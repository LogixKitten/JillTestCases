package edu.tamut.tests;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.concurrent.TimeUnit;

public class TermsOfService {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;

  @Before
  public void setUp() throws Exception {
    // Ensure the correct path for msedgedriver.exe
    System.setProperty("webdriver.edge.driver", "C:\\Users\\ethan\\OneDrive\\Documents\\edgedriver_win64\\msedgedriver.exe");

    // Initialize EdgeDriver
    driver = new EdgeDriver();
    baseUrl = "https://www.google.com/";

    // Set timeouts
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    // Initialize JavaScript Executor
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testTermsOfService() throws Exception {
    driver.get("https://www.jillai.tech/");
    
    // Scroll to the bottom of the page
    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

    // Add a delay so you can see the scroll (optional)
    js.executeScript("window.scrollBy(0, 2500)"); 

      Thread.sleep(2000);  // wait for 2 seconds
  

    // Click the "Terms Of Service" link
      
    driver.findElement(By.linkText("Terms Of Service")).click();
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
