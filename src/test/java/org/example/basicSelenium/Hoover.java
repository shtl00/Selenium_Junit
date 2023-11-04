package org.example.basicSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Hoover {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
    }
    @Test
    public void mouseHoover() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");
        WebElement hover= driver.findElement(By.id("mousehover"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        Actions actions= new Actions(driver);

        Action action = (Action) actions.moveToElement(hover).build();

        Thread.sleep(3000);
        //  action.perfom();done
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div/div/div[4]/div[1]/fieldset/div/div/a[1]")).click();

        Thread.sleep(3000);
    }
    @After
    public void closeTest(){
        driver.close();
    }
}
