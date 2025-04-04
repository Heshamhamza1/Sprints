package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart {
        WebDriver driver;
    @FindBy(id ="option-label-size-143-item-166")
        WebElement cartCount;
    public Cart(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
    }
    @FindBy(id ="option-label-size-143-item-166")
    WebElement size ;
    public void Size(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(size));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", size);
        size.click();
    }
    @FindBy (id = "option-label-color-93-item-50")
        WebElement color;
    public void color(WebDriver driver)
            {
            color.click();
            driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[3]/div/div[1]/form/button")).click();
        }
    }

