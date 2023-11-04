package org.example.basicSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class EnabledDisabled {
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
        driver.findElement(By.id("disabled-button")).click();
        Boolean isTexinputDisabled=driver.findElement(By.id("enabled-example-input")).isEnabled();
        System.out.println(isTexinputDisabled);
        Thread.sleep(6000);
    }
    @Test
    public void enabledTest() throws InterruptedException {
        driver.findElement(By.id("enabled-button")).click();
        Boolean isTexinputboxEnabled=driver.findElement(By.id("enabled-example-input")).isEnabled();
        System.out.println(isTexinputboxEnabled);
        Thread.sleep(6000);
        assertTrue(isTexinputboxEnabled);


    }

    @After
    public void tearDown(){
        driver.close();
    }
}
