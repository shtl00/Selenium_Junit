package org.example.basicSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFramPractice {
    WebDriver driver;
    @Before
    public void setUpBrowser(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();
    }
    @Test
    public void switchToIfram() throws InterruptedException {

        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");


        driver.findElement(By.xpath("//*[@id=\"iframe-example-div\"]"));

        Thread.sleep(3000);
        driver.switchTo().frame("iframe-name");
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div[2]/div[2]/form/div/input")).sendKeys("python");

        Thread.sleep(6000);
    }
    @After
    public void closeTest() {
        driver.close();
    }}
