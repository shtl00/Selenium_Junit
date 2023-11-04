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

public class SwitchIfram {
    WebDriver driver;
    @Before
    public void setUpBrowser(){
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void switchToIfram() throws InterruptedException {

        driver=new ChromeDriver();
        driver.get("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(3000);
        WebElement iframe = driver.findElement(By.id("iframe-example-div"));
        driver.switchTo().frame(0);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div[2]/div[2]/form/div/input")).sendKeys("python");
        Thread.sleep(3000);

    }
    @After
    public void closeTest(){
        driver.close();
    }
}
