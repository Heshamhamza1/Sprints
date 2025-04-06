package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckCartCount {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a")
    private WebElement cart;

    public CheckCartCount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCart(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(cart));
        cart.click();
    }
    public void Added (WebDriver driver)
    {
        WebElement success = driver.findElement(By.cssSelector("div.block-content"));
        String content = success.getText();
        if (!content.contains("You have no items in your shopping cart.\n")) {
            System.out.println("Added successfully:\n"+ content);
        }
        else {
            System.out.println("Failed to add to cart");
        }
    }
}
