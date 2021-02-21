package com.cybertek.tests.day09_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {
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
    public void test1() {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        driver.findElement(By.xpath("//button[.='Destroy the World']")).click();

        driver.findElement(By.xpath("//button[.='No']")).click();

    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        //click Click for JS Alert
        driver.findElement(By.xpath("//button[1]")).click();

        // switch to JS alert pop up
        Alert alert = driver.switchTo().alert();
        alert.accept();



        // click for JS confirm
        driver.findElement(By.xpath("//button[2]")).click();
        alert.dismiss();

        // click for JS prompt
        driver.findElement(By.xpath("//button[3]")).click();
        alert.sendKeys("Mike Smith");
        // click OK
        alert.accept();
    }
}
