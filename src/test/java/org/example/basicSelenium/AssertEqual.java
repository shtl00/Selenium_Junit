package org.example.basicSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class AssertEqual {  WebDriver driver;
    String baseUrl;
    @Before
    public void browserSetup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        baseUrl = ("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @Test
    public void compareUrl(){
        String actualUrl=driver.getCurrentUrl();
        System.out.println(baseUrl);
        System.out.println(actualUrl);
        assertEquals(baseUrl,actualUrl);
    }
    @After
    public void closeTest(){

        driver.close();
    }
}
