package com.cybertek.tests.day08_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTest {

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

            //1. locate your dropdown just any other web element unique  locator
            WebElement dropdownElement = driver.findElement(By.id("state"));
            //2. create Select object by passing that element as a constructor
            Select stateDropdown = new Select(dropdownElement);

            List<WebElement> options = stateDropdown.getOptions();
            System.out.println(options.size());

            //print options by one by
            for (WebElement option : options) {
                System.out.println(option.getText());
            }

        }

        @Test
    public void test2() throws InterruptedException {
            driver.get("http://practice.cybertekschool.com/dropdown");

            //1. locate your dropdown just any other web element unique  locator
            WebElement dropdownElement = driver.findElement(By.id("state"));
            //2. create Select object by passing that element as a constructor
            Select stateDropdown = new Select(dropdownElement);

            //verify that first selection is Select a state
            Assert.assertEquals(stateDropdown.getFirstSelectedOption().getText(), "Select a State");

            //How to select options from dropdown?

            //1.select using visible text
            Thread.sleep(2000);
            stateDropdown.selectByVisibleText("Virginia");

            String expectedOption = "Virginia";
            String actualOption = stateDropdown.getFirstSelectedOption().getText();
            Assert.assertEquals(expectedOption,actualOption, "verify selected selection");


            //2.select using index
            Thread.sleep(2000);
            stateDropdown.selectByIndex(51);

            expectedOption="Wyoming";
            actualOption = stateDropdown.getFirstSelectedOption().getText();
            Assert.assertEquals(actualOption,expectedOption,"verify selected option");

            //3. select using value
            Thread.sleep(2000);
            stateDropdown.selectByValue("TX");

            expectedOption="Texas";
            actualOption = stateDropdown.getFirstSelectedOption().getText();
            Assert.assertEquals(actualOption,expectedOption,"verify selected option");
        }

    }
