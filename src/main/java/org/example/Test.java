package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Test {
    WebDriver driver;

        @BeforeTest
        public void setUp() {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.navigate().to("https://magento.softwaretestingboard.com/men/tops-men/hoodies-and-sweatshirts-men.html");
            driver.manage().window().maximize();
        }

        @org.testng.annotations.Test (priority = 2)
        public void testProductSearch() throws InterruptedException {
            HomePage homePage = new HomePage(driver);
            homePage.searchForProduct("hoodie");
            homePage.Scroll(driver);
        }
    @org.testng.annotations.Test (priority = 1)
        public void testAddToCart() {
            Cart productPage = new Cart(driver);
            productPage.selectSize(driver);
            productPage.selectColorAndAddToCart(driver);
        }
    @org.testng.annotations.Test (priority = 3)
    public void testCheckCartCount() throws InterruptedException {
        CheckCartCount c = new CheckCartCount(driver);
        c.clickCart(driver);
    }
        // you can comment after test function to see results
        @AfterTest
        public void tearDown() {
            driver.quit();
        }
}
