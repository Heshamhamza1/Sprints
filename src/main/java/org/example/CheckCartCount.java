package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckCartCount {
    @FindBy(className = "/html/body/div[2]/header/div[2]/div[1]/a")
    WebDriver driver;
    public CheckCartCount (WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a")
    WebElement cart;
    public void click(WebDriver driver)
        {
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOf(cart));
            cart.click();
        }
}
