package org.example.basicSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {
    WebDriver driver;
    @Before
    public void setUpChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test
    public void openNextWebsite(){
        driver.manage().window().maximize();
        driver.get("https://www.next.co.uk/");
    }

    @Test
    public void openNetflixWebsite(){

        driver.get("https://www.netflix.com/");
    }

    @Test
    public void openBandQ(){
        driver.get("https://www.diy.com/");
    }

    @After
    public void closeTest(){

        driver.close();
    }
}


