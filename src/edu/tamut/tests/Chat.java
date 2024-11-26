package edu.tamut.tests;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Chat {
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

    // Initialize JavaScript Executor
    js = (JavascriptExecutor) driver;
  }
  
  private boolean waitForBotResponse(int timeoutInSeconds) {
    for (int i = 0; i < timeoutInSeconds; i++) {
      try {
        if (driver.findElement(By.id("incoming-message")).isDisplayed()) {
          return true;
        }
      } catch (NoSuchElementException e) {
        // Element not yet present, so wait and try again
      }
      try {
        Thread.sleep(1000);  // Wait for 1 second before the next check
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
    return false;  // Returns false if the response never appears within the timeout
  }

  @Test
  public void testChat() throws Exception {
    // Test login functionality with Thread.sleep() for pauses
    driver.get("https://www.jillai.tech/");
    
    // Pause before interacting with elements
    Thread.sleep(2000);  // Wait for 2 seconds for page load
    driver.findElement(By.linkText("Login")).click();
    
    Thread.sleep(2000);  // Wait for 2 seconds for login form to appear
    WebElement usernameField = driver.findElement(By.name("username"));
    usernameField.clear();
    usernameField.sendKeys("Hamster");

    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.clear();
    passwordField.sendKeys("Mu2SW$16Y");

    Thread.sleep(1000);  // Wait for 1 second before clicking submit
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(1000);  // Wait for 1 second before clicking submit

    driver.findElement(By.linkText("Begin Chat")).click();
    
    Thread.sleep(5000);
    WebElement chatInput = driver.findElement(By.id("chat-input"));
    chatInput.sendKeys("Hello, this is a test");
    chatInput.sendKeys(Keys.ENTER);
    
    WebDriverWait wait = new WebDriverWait(driver, 45);
    Thread.sleep(5000);

    // Wait until the element with class "p" is visible
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.chat-message.incoming-message p")));
    
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
