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
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop { WebDriver driver;
    @Before
    public void setUpBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }
    @Test
    public void DragAndDrop() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Dynamic.html");
        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(1000);

        driver.findElement(By.className("fc-button-label")).click();

        WebElement source= driver.findElement(By.id("mongo"));
        WebElement target= driver.findElement(By.id("droparea"));

        Actions actions=new Actions(driver);
        Action action =actions.dragAndDrop(source,target).build();
        action.perform();
        Thread.sleep(3000);
    }
    @Test
    public void practiceDragDrop() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/drag-and-drop");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(1000);

        WebElement source= driver.findElement(By.id("column-a"));
        WebElement target= driver.findElement(By.id("column-b"));
        Actions actions =new Actions(driver);
        Action action =actions.dragAndDrop(source,target).build();
        action.perform();
        Thread.sleep(3000);
    }
    @After
    public void closeTest(){
        driver.close();
    }
}
