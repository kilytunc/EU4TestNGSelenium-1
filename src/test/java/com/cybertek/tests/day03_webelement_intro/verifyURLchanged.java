package com.cybertek.tests.day03_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchanged {
    public static void main(String[] args) throws InterruptedException {

        // open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to website
        driver.get("http://practice.cybertekschool.com/forgot_password");
        //enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));
        //sendKeys() ---> send keyboard action to the web element
        emailInputBox.sendKeys("legolas@cybertek.com");

        //click retrieve password button
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));

        retrievePasswordButton.click();
       // Thread.sleep(3000);
        String expectedURL = "http://practice.cybertekschool.com/email_sent";
        String actualURL = driver.getCurrentUrl();
        if (actualURL.equals("http://practice.cybertekschool.com/email_sent")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actualURL = " + actualURL);
            System.out.println("expectedURL = " + expectedURL);
        }

    }
}
