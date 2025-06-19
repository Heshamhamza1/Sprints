package org.example;

import Baseclass.BaseClass;

import org.openqa.selenium.*;


public class CheckCartCount extends BaseClass {
    public CheckCartCount(WebDriver driver) {
        super(driver);
    }


    public void clickCart() {
        waitForElement("xpath", "/html/body/div[2]/header/div[2]/div[1]/a", "clickable", 5).click();

    }

    public void verifyItemAdded() {
        waitForElement("css", "div.minicart-items-wrapper", "visible", 5);
        waitForElement("css", "div.price-container", "visible", 5);

        WebElement success = Element("css", "div.minicart-items-wrapper");
        WebElement qtyElement = Element("xpath", "//*[contains(@class, 'item-qty') and contains(@class, 'cart-item-qty')]");

        String content = success.getText();
        String quantity = qtyElement.getTagName().equals("input") ? qtyElement.getAttribute("value") : qtyElement.getText();

        if (!content.contains("You have no items in your shopping cart.")) {
            content = content.replaceAll("(?i)\\b(Edit|Remove)\\b", "")
                    .replaceAll("(?i)\\bSee Details\\b", "Price:");
            System.out.println("Added successfully:\n" + content.trim() + ":" + quantity);
        } else {
            System.out.println("Failed to add to cart");
        }
    }
}
