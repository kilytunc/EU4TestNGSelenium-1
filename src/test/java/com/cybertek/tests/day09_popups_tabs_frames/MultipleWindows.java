package com.cybertek.tests.day09_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
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
        driver.get("http://practice.cybertekschool.com/windows");

        //get the title
        System.out.println("Title before new window = " + driver.getTitle());

        String windowHandle1 = driver.getWindowHandle();

        driver.findElement(By.xpath("//*[.='Click Here']")).click();

        System.out.println("Title after new window without switch= " + driver.getTitle());

        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            if (!windowHandle1.equals(windowHandle)){
                driver.switchTo().window(windowHandle);
            }
        }

        System.out.println("Title after new window with switch= " + driver.getTitle());


    }

    @Test
    public void moreThan2Window(){
        driver.get("http://practice.cybertekschool.com/windows");
        System.out.println("Title before new window = " + driver.getTitle());
        driver.findElement(By.xpath("//*[.='Click Here']")).click();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals("New Window")){
                //stop on that window
                break;
            }
        }

        System.out.println("After Switch = " + driver.getTitle());
    }
}
