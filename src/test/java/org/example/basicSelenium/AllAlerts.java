package org.example.basicSelenium;

public class AllAlerts {
    WebDriver driver;
    @Before
    public void setupbrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");
    }
    @Test
    public void alertTest() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(1000);

        driver.findElement(By.id("name")).sendKeys("sheetal");
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);}
    @Test
    public void confirmAlert() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(1000);

        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(3000);
    }
    @Test
//dismiss for cancellation alert
    public void dismissAlert() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(1000);

        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(3000);
    }
//@Test
//public void getTextAlert() throws InterruptedException {
    //       JavascriptExecutor js = (JavascriptExecutor) driver;
    //  js.executeScript("window.scrollBy(0,350)", "");
//    Thread.sleep(1000);

    // driver.findElement(By.id("alertbtn")).click();
    // Thread.sleep(3000);
    ///  driver.switchTo().alert().getText();
    // Thread.sleep(3000);

    //}
    @After
    public void closeTest(){
        driver.close();}

}

