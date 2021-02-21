package com.cybertek.tests.day04_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTextAndPartialLinkText {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        //make browser fullscreen
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_loading");


        // full link text
        WebElement link1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
       // link1.click();

        // part of link text
        WebElement link4 = driver.findElement(By.partialLinkText("Example 4"));
        link4.click();
    }
}
