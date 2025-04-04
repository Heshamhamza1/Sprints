package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart {
    private WebDriver driver;

    @FindBy(id = "option-label-size-143-item-166")
    private WebElement size;

    @FindBy(id = "option-label-color-93-item-50")
    private WebElement color;

    @FindBy(xpath = "//*[@id='maincontent']/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[3]/div/div[1]/form/button")
    private WebElement addToCartButton;

    public Cart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectSize(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(size));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", size);
        size.click();
    }

    public void selectColorAndAddToCart(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(color)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }
}
