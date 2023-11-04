package org.example.basicSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class CheckBoxExample {
    WebDriver driver;
    @Before
    public void setupChrome(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");
    }
    @Test
    public void checkboxTest() throws InterruptedException {

        driver.findElement(By.id("bmwcheck")).click();
        Boolean isBMWSelected=driver.findElement(By.id("bmwcheck")).isSelected();
        System.out.println(isBMWSelected);
        assertTrue(isBMWSelected);
        Thread.sleep(4000);

        driver.findElement(By.id("benzcheck")).click();
        Thread.sleep(4000);
    }
    @After
    public void tesClose(){
        driver.close();
    }
}
