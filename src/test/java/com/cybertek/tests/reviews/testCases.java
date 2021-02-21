package com.cybertek.tests.reviews;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class testCases {

    public static void testCase01(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.de/");

        WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
        input.sendKeys("Iphone X");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        WebElement result = driver.findElement(By.xpath("//h1"));
        System.out.println("result.getText() = " + result.getText());



    }

    public static void testCase02(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.de/");

        WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
        input.sendKeys("Selenium");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        if (driver.getTitle().toLowerCase().contains("selenium")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("driver.getTitle() = " + driver.getTitle());
        }


    }

    public static void testCase03(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org/");

        driver.findElement(By.xpath("//input[@*='search']")).sendKeys("selenium webdriver");

        driver.findElement(By.xpath("//*[@*='search-input-button']")).click();

        driver.findElement(By.xpath("//a[@*='Selenium (software)']")).click();

        if (driver.getCurrentUrl().endsWith("Selenium_(software)")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        }




    }

    public static void homeWork2(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        System.out.println("Home Link = " + driver.findElement(By.xpath("//a[@*='nav-link']")).getText());
        System.out.println("Forgot Password Header = " + driver.findElement(By.xpath("//*[text()='Forgot Password']")).getText());
        System.out.println("E-mail Text = " + driver.findElement(By.xpath("//*[text()='E-mail']")).getText());
        driver.findElement(By.xpath("//input[@*='text']")).sendKeys("hebele@hübele.com");
        //System.out.println("E-mail Input Box = " + driver.findElement(By.xpath("//input[@*='text']")).toString());
        System.out.println("Retrieve password Button= " + driver.findElement(By.xpath("//*[contains(text(),'Retrieve')]")).getText());



    }

    public static void amazonVerifySelenium(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.de/");
        driver.findElement(By.xpath("//*[@*='nav-search-field ']/input")).sendKeys("selenium");
        driver.findElement(By.xpath("//*[@*='nav-search-submit-text']/input")).click();
        System.out.println(" Result = " + driver.findElement(By.xpath("//*[@*='a-section a-spacing-small a-spacing-top-small']/span[1]")).getText());

    }

    public static void main(String[] args) {
        //testCase01();
        //testCase02();
        //testCase03();
        //homeWork2();
        amazonVerifySelenium();
    }

}
