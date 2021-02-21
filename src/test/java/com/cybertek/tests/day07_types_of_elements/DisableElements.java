package com.cybertek.tests.day07_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisableElements {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenRadioButton = driver.findElement(By.id("green"));

        //how to check any web element is enable or not?
        System.out.println("greenRadioButton.isEnabled() = " + greenRadioButton.isEnabled());
        Assert.assertFalse(greenRadioButton.isEnabled(),"verify this button is not enable");


        greenRadioButton.click();
    }

     @Test
    public void test2(){
         WebDriver driver = WebDriverFactory.getDriver("chrome");
         driver.manage().window().maximize();
         driver.get("http://practice.cybertekschool.com/dynamic_controls");

         WebElement inputBox = driver.findElement(By.cssSelector("#input-example>[type='text']"));
         inputBox.sendKeys("hebele");


         //Assert.assertFalse(driver.findElement(By.cssSelector("#input-example>[type='text']")).isEnabled());
     }
}
