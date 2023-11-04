package org.example.basicSelenium;

public class AssertEqual { WebDriver driver;
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
