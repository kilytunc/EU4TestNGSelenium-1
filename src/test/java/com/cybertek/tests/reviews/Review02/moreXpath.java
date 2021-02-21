package com.cybertek.tests.reviews.Review02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class moreXpath {

    @Test

    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");
        String xpathLocator = "//div[@id='nav-xshop']/*[.='Gift Cards']";
        String path = "Gift Cards";
        WebElement menu = driver.findElement(By.xpath("//div[@id='nav-xshop']/*[.='"+path+"']"));
        //when you deal with menu use this way to make your locator specify
        //it is easy to convert for other menus Locators
        WebElement menu2 = driver.findElement(By.xpath("//div[@id='nav-xshop']/*[.='Gift Cards']"));
        menu.click();


    }
}
