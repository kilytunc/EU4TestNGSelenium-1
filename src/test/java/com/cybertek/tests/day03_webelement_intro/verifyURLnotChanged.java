package com.cybertek.tests.day03_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLnotChanged {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        //click on Retrieve password
        //WebElement --> Interface that represent elements on the webpage
        //findElement --> method used to find element on page.
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        String currentUrl = driver.getCurrentUrl();
        retrievePasswordButton.click();

        //verify that currentUrl did not change
        if(currentUrl.equals(driver.getCurrentUrl())){
            System.out.println("URL didnt change!!!");
            System.out.println("Old URL= "+currentUrl);
            System.out.println("New URL= "+driver.getCurrentUrl());
        }
        driver.quit();
    }
}
