package org.example;

import Baseclass.BaseClass;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;


public class HomePage extends BaseClass {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    WebElement searchBox=Element("id", "search");

    WebElement searchButton=Element("xpath", "//button[@type='submit']");

    public void searchForProduct(String productName) {
        searchBox.sendKeys(productName);
        searchButton.click();
    }

    public void Scroll (WebDriver driver)
    {
        PerformScroll(driver, "elementByxpath","//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[2]/div/a/span/span/img");
    }

    public void printMainContent() {
        WebElement mainContent =Element("css", "div.products");
        String content = mainContent.getText();

        if (!content.isEmpty()) {
            System.out.println("Main content found:\n" + content);
        } else {
            System.out.println("Main content is empty or not found.");
        }
    }
}
