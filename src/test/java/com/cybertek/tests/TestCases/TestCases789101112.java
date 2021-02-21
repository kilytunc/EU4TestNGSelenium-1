package com.cybertek.tests.TestCases;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class TestCases789101112 {

    @DataProvider(name = "testCases")
    public Object[][] createData1() {
        return new Object[][] {
                { "[href='/status_codes']", "[href='status_codes/200']",
                        "//p[contains(text(),'This page returned a 200 status code.')]", "This page returned a 200 status code."},
                { "[href='/status_codes']", "[href='status_codes/301']",
                        "//p[contains(text(),'This page returned a 301 status code.')]", "This page returned a 301 status code."},
                { "[href='/status_codes']", "[href='status_codes/404']",
                        "//p[contains(text(),'This page returned a 404 status code.')]", "This page returned a 404 status code."},
                { "[href='/status_codes']", "[href='status_codes/500']",
                        "//p[contains(text(),'This page returned a 500 status code.')]", "This page returned a 500 status code."},
        };
    }

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
    }


    @AfterMethod

    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test7() {

        driver.findElement(By.cssSelector("[href='/upload']")).click();
        WebElement uploadButton = driver.findElement(By.cssSelector("#file-upload"));
        uploadButton.sendKeys("C:\\Users\\ZdN\\Desktop\\HomeWork.pdf");
        driver.findElement(By.cssSelector("#file-submit")).click();
        String uploadedText = driver.findElement(By.xpath("//div[@id='content']//h3")).getText();
        String uploadedFilesName = driver.findElement(By.cssSelector("#uploaded-files")).getText();

        Assert.assertEquals(uploadedText,"File Uploaded!");
        Assert.assertEquals(uploadedFilesName,"HomeWork.pdf");


    }

    @Test
    public void test8() {

        driver.findElement(By.cssSelector("[href='/autocomplete']")).click();
        driver.findElement(By.cssSelector("#myCountry")).sendKeys("United States of America");
        driver.findElement(By.cssSelector("[type='button']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='result']")).getText(),"You selected: United States of America");

    }

    @Test (dataProvider = "testCases")
    public void test9(String xpath1,String xpath2,String xpath3,String expectedText) {

        driver.findElement(By.cssSelector(xpath1)).click();
        driver.findElement(By.cssSelector(xpath2)).click();
        WebElement ActualTextElement = driver.findElement(By.xpath(xpath3));

        Assert.assertTrue(ActualTextElement.getText().contains(expectedText));

    }
}
