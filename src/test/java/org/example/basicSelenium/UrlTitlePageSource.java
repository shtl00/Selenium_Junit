package org.example.basicSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class UrlTitlePageSource {
    WebDriver driver;
    String baseUrl;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        baseUrl = "https://demo.nopcommerce.com/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    //HTML Online Editor-W3 school
    @Test
    public void myUrlTitlePageSource(){
        String myCurrentUrl=driver.getTitle();
        String myCurrentTitle=driver.getTitle();
        String myCurrentPageSource=driver.getPageSource();
        String myCurentWindowHandel=driver.getWindowHandle();

        System.out.println(myCurrentUrl);
        System.out.println(myCurrentTitle);
        System.out.println(myCurrentPageSource);
        System.out.println(myCurentWindowHandel);
    }
    @After
    public void closeTest(){
        driver.close();
    }

}
