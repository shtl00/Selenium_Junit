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

public class DisabledEnabled {
    WebDriver driver;
    @Before
    public void setupChrome(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");
    }
    @Test
    public void disabledTest() throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        driver.findElement(By.id("disabled-button")).click();
        boolean isTexInputboxEnabled=driver.findElement(By.id("enabled-example-input")).isEnabled();
        System.out.println(isTexInputboxEnabled);
        assertFalse(isTexInputboxEnabled);
        Thread.sleep(6000);
    }
    @Test
    public void enabledTest() throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        driver.findElement(By.id("enabled-button")).click();
        Boolean isTexinputboxDisabled=driver.findElement(By.id("enabled-example-input")).isEnabled();
        System.out.println(isTexinputboxDisabled);
        Thread.sleep(6000);
        assertTrue(isTexinputboxDisabled);
    }

    @Test
    public void enabledPractice() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(3000);
        driver.findElement(By.id("enabled-button")).click();
        driver.findElement(By.id("enabled-example-input")).isEnabled();
        driver.findElement(By.id("enabled-example-input")).sendKeys("sheetal");
        Thread.sleep(3000);
    }
    @After
    public void tearDown()
    {
        driver.close();
    }
}
