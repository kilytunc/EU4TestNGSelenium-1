package com.cybertek.tests.day06_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CssLocator {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        System.out.println(" By.cssSelector(\"#disappearing_button\") = " + driver.findElement(By.cssSelector("#disappearing_button")).getText());

        driver.quit();
    }
}
