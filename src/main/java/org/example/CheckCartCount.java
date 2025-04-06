package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class CheckCartCount {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a")
    private WebElement cart;

    public CheckCartCount(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void clickCart(WebDriver driver) {
        wait.until(ExpectedConditions.visibilityOf(cart)).click();
    }

    public void verifyItemAdded(WebDriver driver) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.minicart-items-wrapper")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.price-container")));

        WebElement success = driver.findElement(By.cssSelector("div.minicart-items-wrapper"));
        WebElement qtyElement = driver.findElement(By.xpath("//*[contains(@class, 'item-qty') and contains(@class, 'cart-item-qty')]"));

        String content = success.getText();
        String quantity = qtyElement.getTagName().equals("input") ? qtyElement.getAttribute("value") : qtyElement.getText();

        if (!content.contains("You have no items in your shopping cart.")) {
            content = content.replaceAll("(?i)\\b(Edit|Remove)\\b", "")
                    .replaceAll("(?i)\\bSee Details\\b", "Price:");
            System.out.println("Added successfully:\n" + content.trim() + ": " + quantity);
        } else {
            System.out.println("Failed to add to cart");
        }
    }
}
