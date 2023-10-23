package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenUrl {
    @Test
public void openZaraWebsite(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.zara.com/uk/");
}
    @Test
    public void openDemonopCommers(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }
    @Test
    public void openArgosWebSite(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.argos.co.uk/");
    }
    @Test
    public void openNextWebSite(){
        WebDriverManager.chromedriver().setup();
        WebDriver drive =new ChromeDriver();
        drive.manage().window().maximize();
        drive.get("https://www2.next.co.uk/");
    }

}
