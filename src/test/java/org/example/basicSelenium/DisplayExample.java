package org.example.basicSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DisplayExample {
    WebDriver driver;
    @Before
    public void setupChrome(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");
    }
    @Test
    public void openLetsKodIt() throws InterruptedException {


        driver.findElement(By.xpath("// input[@id='bmwradio']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@id='benzradio']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='autosuggest']")).click();
        Thread.sleep(3000);
    }
    @After
    public void CloseTest(){
        driver.close();
    }
}
