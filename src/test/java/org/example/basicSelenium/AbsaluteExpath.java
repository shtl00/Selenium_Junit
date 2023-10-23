package org.example.basicSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbsaluteExpath {
    WebDriver driver;
    @Before
    public void setupChrome(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");
    }
    @Test
    public void OpenLetskodIt() throws InterruptedException {

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div/div/div[1]/div[1]/fieldset/label[1]/input")).click();
        Thread.sleep(4000);

    }
    @After
    public void closeTest(){
        driver.close();

    }
}
