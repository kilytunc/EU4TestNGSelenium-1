package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class loginTest extends TestBase {


    @Test
    public void openBrowserWithConf(){



        driver.get(ConfigurationReader.get("url"));

        String userName = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        driver.findElement(By.cssSelector("#prependedInput")).sendKeys(userName);
        driver.findElement(By.cssSelector("#prependedInput2")).sendKeys(password+ Keys.ENTER);

    }

}
