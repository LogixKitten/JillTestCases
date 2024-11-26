package edu.tamut.tests;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

public class ChatMemory {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;

  @Before
  public void setUp() throws Exception {
    // Set the path for msedgedriver.exe
    System.setProperty("webdriver.edge.driver", "C:\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\ethan\\\\\\\\\\\\\\\\OneDrive\\\\\\\\\\\\\\\\Documents\\\\\\\\\\\\\\\\edgedriver_win64\\\\\\\\\\\\\\\\msedgedriver.exe"); // Update this path with the correct location of msedgedriver.exe

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
        Thread.sleep(1000); // Wait for 1 second before the next check
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
    return false; // Returns false if the response never appears within the timeout
  }

  @Test
  public void testChatMemory() throws Exception {
    // Test login functionality with Thread.sleep() for pauses
    driver.get("https://www.jillai.tech/");

    // Pause before interacting with elements
    Thread.sleep(2000); // Wait for 2 seconds for page load
    driver.findElement(By.linkText("Login")).click();

    Thread.sleep(2000); // Wait for 2 seconds for login form to appear
    WebElement usernameField = driver.findElement(By.name("username"));
    usernameField.clear();
    usernameField.sendKeys("Hamster");

    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.clear();
    passwordField.sendKeys("Mu2SW$16Y");

    Thread.sleep(1000); // Wait for 1 second before clicking submit
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(1000); // Wait for 1 second before clicking submit

    driver.findElement(By.linkText("Begin Chat")).click();

    // Send a message in the chat to trigger a response
    WebElement chatInput = driver.findElement(By.id("chat-input"));
    Thread.sleep(30000);
    chatInput.sendKeys("Hello, this is a test. Can you remember my secret number, 15?");
    chatInput.sendKeys(Keys.ENTER);
    Thread.sleep(30000);
    driver.findElement(By.cssSelector(".chat-message.incoming-message.incoming-container"));
    chatInput.sendKeys("What is my secret number?");
    chatInput.sendKeys(Keys.ENTER);
    Thread.sleep(30000);
    driver.findElement(By.cssSelector(".chat-message.incoming-message.incoming-container"));
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
