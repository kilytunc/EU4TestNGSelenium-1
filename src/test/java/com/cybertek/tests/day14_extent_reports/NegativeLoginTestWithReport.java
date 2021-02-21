package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest(){
        //name of test
        extentLogger = report.createTest("Wrong Password Test");


        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter Username: User1");
        loginPage.usernameInput.sendKeys("user1");

        extentLogger.info("Enter Password : someword");
        loginPage.passwordInput.sendKeys("someword");

        extentLogger.info("Click login button");
        loginPage.loginButton.click();


//        driver.findElement(By.id("prependedInput")).sendKeys("username");
//        driver.findElement(By.id("prependedInput2")).sendKeys("fsdaf");
//        driver.findElement(By.id("_submit")).click();

        extentLogger.info("Verify PAge Url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        //this line will execute after test passed.
        extentLogger.pass("Wrong Password Test is passed.");
    }

    @Test
    public void wrongUserName(){
        extentLogger = report.createTest("Wrong USername Test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter Username: User1");
        loginPage.usernameInput.sendKeys("someusername");

        extentLogger.info("Enter Password : someword");
        loginPage.passwordInput.sendKeys("UserUser123");

        extentLogger.info("Click login button");
        loginPage.loginButton.click();

        extentLogger.info("Verify PAge Url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/logindsf");
        extentLogger.pass("Wrong Password Test is passed.");

    }
}
