package com.cybertek.tests.day07_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributeTest {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.id("blue"));
        System.out.println("blueRadioButton.getAttribute(\"value\") = " + blueRadioButton.getAttribute("value"));

        //get the value of type attribute
        System.out.println("(\"type\") = " + blueRadioButton.getAttribute("type"));
        System.out.println("(\"name\") = " + blueRadioButton.getAttribute("name"));
        System.out.println("(\"checked\") = " + blueRadioButton.getAttribute("checked"));
        System.out.println("(\"href\") = " + blueRadioButton.getAttribute("href"));
        System.out.println("(\"outerHTML\") = " + blueRadioButton.getAttribute("outerHTML"));

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement button = driver.findElement(By.name("button2"));
        System.out.println("(\"innerHTML\") = " + button.getAttribute("innerHTML"));
        System.out.println("(\"outerHTML\") = " + button.getAttribute("outerHTML"));

        driver.quit();


    }
}