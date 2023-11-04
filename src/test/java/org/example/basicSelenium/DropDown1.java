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
import org.openqa.selenium.support.ui.Select;

public class DropDown1 {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }
    @Test
    public void dropDown() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");
        WebElement dropdown= driver.findElement(By.id("carselect"));
        Select selectDropDown = new Select(dropdown);
        selectDropDown.selectByIndex(2);
        Thread.sleep(3000);

        selectDropDown.selectByValue("bmw");
        Thread.sleep(3000);

        selectDropDown.selectByVisibleText("Benz");
        Thread.sleep((3000));
    }
    @Test
    public void dropDownCurrency() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        WebElement dropdown=driver.findElement(By.id("customerCurrency"));
        Select selectDropDown=new Select(dropdown);
        selectDropDown.selectByIndex(0);
        Thread.sleep(4000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        selectDropDown.selectByValue("https://demo.nopcommerce.com/changecurrency/1?returnUrl=%2F");
        Thread.sleep(4000);

    }
    @After
    public void closeTest(){
        driver.close();
    }
}
