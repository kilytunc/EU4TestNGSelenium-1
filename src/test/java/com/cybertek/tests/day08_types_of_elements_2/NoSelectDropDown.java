package com.cybertek.tests.day08_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropDown {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropDownElement = driver.findElement(By.id("dropdownMenuLink"));

        //click the dropdown to see available options
        dropDownElement.click();

        List<WebElement> dropdownOptions = driver.findElements(By.className("dropdown-item"));

        System.out.println(dropdownOptions.size());

        //print them by one by
        for (WebElement dropdownOption : dropdownOptions) {
            System.out.println(dropdownOption.getText());
        }

        //click yahoo
        dropdownOptions.get(2).click();

    }
}
