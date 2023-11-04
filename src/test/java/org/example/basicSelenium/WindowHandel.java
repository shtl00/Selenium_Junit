package org.example.basicSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowHandel {
    WebDriver driver;
    @Before
    public void setupBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();
    }
    @Test // how to find current browser
    public void windowHandelTest(){
        driver.findElement(By.id("openwindow")).click();
        Set<String> windowHandels =driver.getWindowHandles();

        for (String windowHandel:windowHandels)
        {
            System.out.println(windowHandel);}
        System.out.println("current browser");
        System.out.println(driver.getWindowHandle());
    }
    @Test
    public void windowSwitch() throws InterruptedException {
        System.out.println("current browser");
        System.out.println(driver.getWindowHandle());
        String mainWindowHandels = driver.getWindowHandle();

        driver.findElement(By.id("openwindow")).click();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(mainWindowHandels))
            {driver.switchTo().window(windowHandle);
                Thread.sleep(3000);
                driver.findElement(By.id("search")).click();
                Thread.sleep(3000);
            }}
    }
    @After
    public void closeTest(){
        driver.quit();
    }

}
