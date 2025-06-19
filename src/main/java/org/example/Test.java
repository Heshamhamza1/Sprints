package org.example;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class Test {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        Main.startReport();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://magento.softwaretestingboard.com/men/tops-men/hoodies-and-sweatshirts-men.html");
        driver.manage().window().maximize();
    }
    @org.testng.annotations.Test(priority = 2)
    public void testProductSearch() throws InterruptedException {
        Main.test = Main.extent.createTest("testProductSearch");
        HomePage homePage = new HomePage(driver);
        homePage.searchForProduct("hoodie");
        homePage.printMainContent();
        homePage.Scroll(driver);
        Main.test.log(Status.PASS, "Product search test completed.");
    }

    @org.testng.annotations.Test(priority = 1)
    public void testAddToCart() {
        Main.test = Main.extent.createTest("testAddToCart");
        Cart productPage = new Cart(driver);
        productPage.selectSize(driver);
        productPage.selectColorAndAddToCart();
        Main.test.log(Status.PASS, "Add to cart test completed.");
    }

    @org.testng.annotations.Test(priority = 3)
    public void testCheckCartCount() throws InterruptedException {
        Main.test = Main.extent.createTest("testCheckCartCount");
        CheckCartCount c = new CheckCartCount(driver);
        c.clickCart();
        c.verifyItemAdded();
        Main.test.log(Status.PASS, "Cart count verified successfully.");
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            Main.test.log(Status.FAIL, "Test Failed: " + result.getName());
            Main.test.log(Status.FAIL, result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            Main.test.log(Status.PASS, "Test Passed: " + result.getName());
        } else {
            Main.test.log(Status.SKIP, "Test Skipped: " + result.getName());
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        Main.flushReport();
    }
}
