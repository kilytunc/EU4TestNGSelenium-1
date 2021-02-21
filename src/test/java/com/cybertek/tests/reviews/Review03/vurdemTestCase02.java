package com.cybertek.tests.reviews.Review03;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class vurdemTestCase02 {
    /*
    *
1.Open Chrome browser
2. Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
3. Verify “Check All” button text is “Check All”
4. Click to “Check All” button
5. Verify all check boxes are checked
6. Verify button text changed to “Uncheck All”*/

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
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkButton = driver.findElement(By.cssSelector("#check1"));
        Assert.assertEquals(checkButton.getAttribute("value"),"Check All");

        checkButton.click();

       // List<WebElement> elements = driver.findElements(By.xpath("//input[@class='cb1-element']"));
        List<WebElement> elements = driver.findElements(By.cssSelector("input[class='cb1-element']"));

        System.out.println(elements.toString());

        for (WebElement element : elements) {
            Assert.assertTrue(element.isSelected());
        }

        Assert.assertEquals(checkButton.getAttribute("value"),"Uncheck All","Verify button text changed to “Uncheck All” ");


    }


}
