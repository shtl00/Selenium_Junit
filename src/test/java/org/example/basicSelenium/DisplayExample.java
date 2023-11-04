package org.example.basicSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DisplayExample {
    WebDriver driver;
    String baseURL="https://www.letskodeit.com/practice";
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
    }
    @Test
    public void isDisplayedTest() throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        driver.findElement(By.id("show-textbox")).click();
        boolean isDisplayed=driver.findElement(By.id("displayed-text")).isDisplayed();
        System.out.println(isDisplayed);
        assertTrue(isDisplayed);
        driver.findElement(By.id("displayed-text")).sendKeys("sheetal");
        Thread.sleep(5000);
    }
    @Test
    public void isNotDisplayedTest() throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        driver.findElement(By.id("hide-textbox")).click();
        boolean isNotDisplayed=driver.findElement(By.id("displayed-text")).isDisplayed();
        System.out.println(isNotDisplayed);
        assertFalse(isNotDisplayed);
        Thread.sleep(5000);
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
