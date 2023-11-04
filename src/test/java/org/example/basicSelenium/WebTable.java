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

import java.util.List;

public class WebTable {
    WebDriver driver;
    @Before
    public void setupBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();
    }
    @Test
    public void webTable() throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        //numbers of row in table
        Thread.sleep(2000);


        List<WebElement> myListOfElement = driver.findElements(By.id("product"));
        System.out.println(myListOfElement.size());
        System.out.println("my list " + myListOfElement);
        for (WebElement myElement : myListOfElement) {
            String myText = myElement.getText();
            System.out.println(myText);
        }}
    @Test
    public void TableDetails() throws InterruptedException {
        List< WebElement> rowelements= driver.findElements(By.xpath("//*[@id=\"product\"]/tbody/tr[2]/td"));
        System.out.println(rowelements.size());
        int rowsize=rowelements.size();

        List<WebElement>columelement= driver.findElements(By.xpath("//*[@id=\"product\"]/tbody/tr[2]/td"));
        System.out.println(columelement.size());

        int colsize=columelement.size();

        for (int i =1;i<=rowsize;i++){
            for(int j=1;j<=colsize;j++){

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,350)", "");
                Thread.sleep(3000);

                System.out.println(driver.findElement(By.xpath("//*[@id=\"product\"]/tbody/tr["+ i +"]/td["+ j +"]")).
                        getText());
            }
        }
    }
    @After
    public void closeTest(){
        driver.close();
    }
}
