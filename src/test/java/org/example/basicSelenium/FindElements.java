package org.example.basicSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElements {
    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "https://demo.nopcommerce.com/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @Test
    public void findElementsPractice() {

        List<WebElement> myListOfElement = driver.findElements(By.xpath("/html/body/div[6]/div[2]/ul[1]/li"));
        System.out.println(myListOfElement.size());
        System.out.println("my list " + myListOfElement);
        for (WebElement myElement : myListOfElement) {
            String myText = myElement.getText();
            System.out.println(myText);

        }}
    @After
    public void tearDown() throws Exception {
        Thread.sleep(10000);
        driver.quit();
    }
}
