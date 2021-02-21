package com.cybertek.tests.TestCases;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCases12345 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href='/registration_form']")).click();
    }


    @AfterMethod

    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.findElement(By.cssSelector("[name='birthday']")).sendKeys("wrong_dob");
        String text = driver.findElement(By.cssSelector("[data-bv-for='birthday'][data-bv-result='INVALID']")).getText();
        Assert.assertEquals(text,"The date of birth is not valid");

    }
    @Test
    public void test2() {

        List<WebElement> elements = driver.findElements(By.cssSelector("[class='form-check-label']"));

        String [] expectedNames = {"C++","Java","JavaScript"};
        String[] elementNames = new String[expectedNames.length];
        for (int i = 0; i < expectedNames.length; i++) {
            elementNames[i] = elements.get(i).getText();
        }

        Assert.assertTrue(Arrays.equals(expectedNames,elementNames));

    }

    @Test
    public void test3() {

        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("k");
        String text = driver.findElement(By.cssSelector("[data-bv-for='firstname'][data-bv-result='INVALID']")).getText();
        Assert.assertEquals(text,"first name must be more than 2 and less than 64 characters long");

    }

    @Test
    public void test4() {

        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("k");
        String text = driver.findElement(By.cssSelector("[data-bv-for='lastname'][data-bv-result='INVALID']")).getText();
        Assert.assertEquals(text,"The last name must be more than 2 and less than 64 characters long");

    }
    @Test
    public void test5() {

        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("Will");
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("Smith");
        driver.findElement(By.cssSelector("[name='username']")).sendKeys("SmithWill");
        driver.findElement(By.cssSelector("[name='email']")).sendKeys("ehegel7q@usatoday.com");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("smithwill");
        driver.findElement(By.cssSelector("[name='phone']")).sendKeys("666-666-6666");
        driver.findElement(By.cssSelector("[value='male']")).click();
        driver.findElement(By.cssSelector("[name='birthday']")).sendKeys("04/18/1994");
        WebElement departmentElement = driver.findElement(By.cssSelector("[name='department']"));
        Select select = new Select(departmentElement);
        select.selectByValue("DE");
        WebElement jobTitleElement = driver.findElement(By.cssSelector("[name='job_title']"));
        Select select2 = new Select(jobTitleElement);
        select2.selectByIndex(5);
        driver.findElement(By.cssSelector("[value='java']")).click();
        driver.findElement(By.id("wooden_spoon")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("[class='alert alert-success'] p")).getText(),
                "You've successfully completed registration!");


    }

}
