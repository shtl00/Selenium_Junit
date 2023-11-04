package org.example.basicSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelect {
    WebDriver driver;

    @Before
    public void setupBrowser(){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();

    }
    @Test
    public void multipalSelectTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");
        WebElement multiSelect= driver.findElement(By.id("multiple-select-example"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        Select selection =new Select(multiSelect);
        Thread.sleep(3000);

        selection.selectByVisibleText("Orange");
        selection.selectByVisibleText("Peach");
        selection.deselectByVisibleText("Orange");
        Thread.sleep(3000);
        selection.selectByVisibleText("Apple");

    }
    @After
    public void closeTest(){
        driver.close();
    }
}

