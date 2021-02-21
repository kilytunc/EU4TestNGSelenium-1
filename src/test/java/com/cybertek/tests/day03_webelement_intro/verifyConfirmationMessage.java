package com.cybertek.tests.day03_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        String expectedEmail = "mike@smith.com";

        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys(expectedEmail);

        //somehow we should get text from web elements
        // two main ways to get txt from web elements
        //1. getText() --> it will work %99 and it will return string
        //2. getAttribute("value") --> second way of getting text especially input boxes

        String actualEmail = emailInputBox.getAttribute("value");
        System.out.println("actualEmail = " + actualEmail);

        //verify that email is displayed in the input box
        if(expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        //click on retrieve password button

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        //verify that confirmation message says "Your email's been sent"

        WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));

        System.out.println(actualConfirmationMessage.getText());

        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = actualConfirmationMessage.getText();

        if(expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
        }

        driver.quit();


    }
}
