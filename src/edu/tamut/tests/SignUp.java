package edu.tamut.tests;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SignUp {
    private WebDriver driver;
    private String baseUrl = "https://www.jillai.tech/";
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;

    @Before
    public void setUp() throws Exception {
        // Set the correct path to your msedgedriver executable
        System.setProperty("webdriver.edge.driver", "C:\\Users\\ethan\\OneDrive\\Documents\\edgedriver_win64\\msedgedriver.exe");

        // Initialize the EdgeDriver
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // Initialize JavaScript Executor
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void testSignUp() throws Exception {
        driver.get("https://www.jillai.tech/");
        driver.findElement(By.linkText("Sign up")).click();
        js.executeScript("window.scrollBy(0, 250);");

        // Add a delay so you can see the scroll (optional)
        Thread.sleep(2000); // wait for 2 seconds

        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("test1_email@gmail.com");
        driver.findElement(By.id("userName")).click();
        driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("userName")).sendKeys("Test2");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("Password1!");	
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0, 2000)"); 
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='One special character'])[1]/following::button[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Welcome!'])[1]/following::div[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Username is available!'])[1]/following::button[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='One special character'])[1]/following::button[1]")).click();
        driver.findElement(By.id("firstNameInput")).click();
        driver.findElement(By.id("firstNameInput")).clear();
        driver.findElement(By.id("firstNameInput")).sendKeys("Test");
        driver.findElement(By.xpath("//div[@id='modal-1']/div/div/div[2]/p[2]")).click();
        driver.findElement(By.name("lastName")).click();
        driver.findElement(By.name("lastName")).clear();
        driver.findElement(By.name("lastName")).sendKeys("Test");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='modal-1']/div/div/div[2]/form")).click();
        driver.findElement(By.xpath("//div[@id='modal-1']/div/div/div[3]/button[2]")).click();
        driver.findElement(By.name("dateOfBirth")).click();
        driver.findElement(By.name("dateOfBirth")).clear();
        Thread.sleep(2000);
        driver.findElement(By.name("dateOfBirth")).sendKeys("12032002");
        driver.findElement(By.xpath("//div[@id='modal-2']/div/div/div[3]/button[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='modal-3']/div/div/div[2]/form/div/label")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='modal-3']/div/div/div[3]/button[2]")).click();
        driver.findElement(By.id("USACheck")).click();
        driver.findElement(By.id("confirmCountryCheck")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("zipCode")).click();
        driver.findElement(By.name("zipCode")).clear();
        driver.findElement(By.name("zipCode")).sendKeys("75503");
        driver.findElement(By.id("modal-4")).click();
        driver.findElement(By.id("submitFormButton")).click();
        Thread.sleep(20000);
        driver.findElement(By.xpath("//div[@id='modal-personality_quiz_start']/div/div/div[3]/button[2]")).click();
        driver.findElement(By.xpath("//form[@id='form-1']/label")).click();
        driver.findElement(By.id("next-question1")).click();
        driver.findElement(By.xpath("//form[@id='form-2']/label")).click();
        driver.findElement(By.id("next-question2")).click();
        driver.findElement(By.xpath("//form[@id='form-3']/label[2]")).click();
        driver.findElement(By.id("next-question3")).click();
        driver.findElement(By.xpath("//form[@id='form-4']/label")).click();
        driver.findElement(By.id("next-question4")).click();
        driver.findElement(By.xpath("//form[@id='form-5']/label[3]")).click();
        driver.findElement(By.id("next-question5")).click();
        driver.findElement(By.xpath("//form[@id='form-6']/label[3]")).click();
        driver.findElement(By.id("next-question6")).click();
        driver.findElement(By.xpath("//form[@id='form-7']/label[2]")).click();
        driver.findElement(By.id("next-question7")).click();
        driver.findElement(By.xpath("//form[@id='form-8']/label[4]")).click();
        driver.findElement(By.id("next-question8")).click();
        driver.findElement(By.xpath("//form[@id='form-9']/label")).click();
        driver.findElement(By.id("form-9")).click();
        driver.findElement(By.xpath("//form[@id='form-9']/label[2]")).click();
        driver.findElement(By.id("next-question9")).click();
        driver.findElement(By.xpath("//form[@id='form-10']/label[2]")).click();
        driver.findElement(By.xpath("//div[@id='modal-question10']/div/div/div[3]/button")).click();
        driver.findElement(By.xpath("//img[@alt='max']")).click();
        driver.findElement(By.xpath("//div[@id='modal-quizResults']/div/div/div[3]/button")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

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
