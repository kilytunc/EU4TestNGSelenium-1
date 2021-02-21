package com.cybertek.tests.day08_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("Chrome");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //save our web elements inside the list.
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        System.out.println("buttons.size() = " + buttons.size());
        //verify buttons number
        Assert.assertTrue(buttons.size()==6);

        for (WebElement button : buttons) {
            System.out.println(button.getText());
            Assert.assertTrue(button.isDisplayed(),"verify buttons are displayed");
        }

        //click second button
        buttons.get(1).click();
    }


    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        //verify your locator is working. when its not working it will not nse error.
        List<WebElement> hebele = driver.findElements(By.tagName("hebele"));
        Assert.assertTrue(hebele.size()!=0);

    }


}
