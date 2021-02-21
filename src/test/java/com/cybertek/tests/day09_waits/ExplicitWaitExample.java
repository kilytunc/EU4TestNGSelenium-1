package com.cybertek.tests.day09_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("Chrome");
    }


    @AfterMethod

    public void tearDown() throws InterruptedException {
        //Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        driver.findElement(By.tagName("button")).click();

        WebElement usernameInput = driver.findElement(By.id("username"));


        //How to wait explicitly?
        //create Explicit wait object
        WebDriverWait wait = new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.visibilityOf(usernameInput));

        usernameInput.sendKeys("mikeSmith");

    }
    @Test
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        //click enable
        driver.findElement(By.xpath("//*[.='Enable']")).click();

        //finding inputBox
        WebElement element = driver.findElement(By.cssSelector("#input-example>input"));

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(element));

        element.sendKeys("Mike Smith");


    }

}
