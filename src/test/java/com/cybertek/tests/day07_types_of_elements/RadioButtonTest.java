package com.cybertek.tests.day07_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //locating radioButton
        WebElement blueRadioButton = driver.findElement(By.cssSelector("#blue"));
        WebElement redRadioButton = driver.findElement(By.id("red"));

        // How to check radio button is selected?
        System.out.println("blueRadioButton.isSelected() = " + blueRadioButton.isSelected());
        System.out.println("redRadioButton.isSelected() = " + redRadioButton.isSelected());

        // how to click radioButton?
        //redRadioButton.click();

        //verify blue is selected red is not selected.
        Assert.assertTrue(blueRadioButton.isSelected(),"verify that blue is selected.");
        Assert.assertFalse(redRadioButton.isSelected(),"verify that red is not selected.");

        Thread.sleep(3000);
        driver.quit();
    }

}
