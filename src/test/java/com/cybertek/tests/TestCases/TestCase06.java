package com.cybertek.tests.TestCases;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase06 {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @AfterMethod

    public void tearDown() throws InterruptedException {
        //Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://www.tempmailaddress.com/");

        String emailText = driver.findElement(By.cssSelector("[id='email']")).getText();

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.cssSelector("[href='/sign_up']")).click();

        driver.findElement(By.name("full_name")).sendKeys("Mike");

        driver.findElement(By.name("email")).sendKeys(emailText);

        driver.findElement(By.name("wooden_spoon")).click();

        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        String actual = driver.findElement(By.name("signup_message")).getText();
        Assert.assertEquals(actual, expected,"Verify that following message is displayed");

        driver.get("https://www.tempmailaddress.com");

       // boolean mailCheck=driver.findElement(By.xpath("//span[.='do-not-reply@practice.cybertekschool.com']")).isEnabled();
        // Assert.assertTrue(mailCheck);

        driver.switchTo().defaultContent();

        String actualEmail = driver.findElement(By.xpath("//span[contains(text(),'do-not')]")).getText();
        String expectedEmail = "do-not-reply@practice.cybertekschool.com";

        Assert.assertEquals(actualEmail,expectedEmail,"Verify that you’ve received an email from");

        driver.findElement(By.xpath("//span[contains(text(),'do-not')]")).click();

        String odesilatel = driver.findElement(By.id("odesilatel")).getText();
        String expectedMailFrom = "do-not-reply@practice.cybertekschool.com";

        Assert.assertEquals(odesilatel,expectedMailFrom,"Verify that email is from");

        String predmet = driver.findElement(By.id("predmet")).getText();
        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";

        Assert.assertEquals(predmet,expectedSubject,"Verify that subject is");


    }
}
