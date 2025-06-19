package org.example;

import Baseclass.BaseClass;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class Cart extends BaseClass {
    public Cart(WebDriver driver) {
        super(driver);
    }

    WebElement size = Element("id","option-label-size-143-item-166");

    public void selectSize(WebDriver driver) {
        waitForElement("id","option-label-size-143-item-166","visible" , 3);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", size);
        size.click();
    }

    public void selectColorAndAddToCart(WebDriver driver) {
        waitForElement("id","option-label-color-93-item-50", "clickable", 3).click();
        waitForElement("xpath", "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[3]/div/div[1]/form/button","clickable", 5).click();
    }
}
