package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemo {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("Chrome");
    }


    @AfterMethod

    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void clickWithJS(){

        driver.get("http://practice.cybertekschool.com/");
        WebElement dropdown = driver.findElement(By.linkText("Dropdown"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();",dropdown);


    }

    @Test
    public void typeWithJS(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.cssSelector("[type='text']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String text = "hebele";
        jse.executeScript("arguments[0].setAttribute('value', '" + text +"')", inputBox);

    }

    @Test
    public void ScrollDownAndUp() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        //driver.manage().window().maximize();

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,250)");
        }

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-250)");
        }


    }

    @Test
    public void scrollToElement() throws InterruptedException {

        driver.get("https://www.amazon.de");
        driver.manage().window().fullscreen();

        WebElement lang = driver.findElement(By.cssSelector("[class='nav-arrow icp-up-down-arrow']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView(true);",lang);





    }

}
