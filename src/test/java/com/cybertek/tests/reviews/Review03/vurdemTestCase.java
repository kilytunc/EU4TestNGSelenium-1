package com.cybertek.tests.reviews.Review03;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class vurdemTestCase {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
    }


    @AfterMethod

    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get("https://www.etsy.com/");

        driver.findElement(By.xpath("//*[contains(text(),'Accept')]")).click();

        //String aim = "Clothing & Shoes";
        String aim = "Wedding & Party";

        String locator = "//span[contains(text(),'"+aim+"')]";

        WebElement hoverover = driver.findElement(By.xpath(locator));

        hoverover.click();



    }

    }
