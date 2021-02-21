package com.cybertek.tests.day07_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement userNameInput = driver.findElement(By.id("username"));
       // userNameInput.sendKeys("hebele"); It is not displayed--->ElementNotInteractableException: element not interactable

        System.out.println("userNameInput.isDisplayed() = " + userNameInput.isDisplayed());
        // verify username is not displayed on the screen
        Assert.assertFalse(userNameInput.isDisplayed());
        // click the start button
        driver.findElement(By.cssSelector("#start>button")).click();
        // wait for the loading
        Thread.sleep(5000);
        // verify username inputBox is displayed on the screen
        Assert.assertTrue(userNameInput.isDisplayed());

        driver.quit();




    }
}
