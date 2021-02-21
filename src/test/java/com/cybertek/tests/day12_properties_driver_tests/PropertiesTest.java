package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest {

    @Test
    public void test1(){

        String browserType = ConfigurationReader.get("browser");
        System.out.println("browserType = " + browserType);



    }

    @Test
    public void openBrowserWithConf(){
        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        //when there is no keyName as browser it returns null
        //when there is more than one KeyName it returns last one

        driver.get(ConfigurationReader.get("url"));
        String userName = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        driver.findElement(By.cssSelector("#prependedInput")).sendKeys(userName);
        driver.findElement(By.cssSelector("#prependedInput2")).sendKeys(password+ Keys.ENTER);

    }


}
