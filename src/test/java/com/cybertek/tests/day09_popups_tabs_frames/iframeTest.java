package com.cybertek.tests.day09_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class iframeTest {
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
        driver.get("http://practice.cybertekschool.com/dropdown");
        //1. locate the dropdown with name
        WebElement dropdownElement = driver.findElement(By.name("Languages"));

        //2. create Select object
        Select langDropdown = new Select(dropdownElement);

        //get the default selection
        //System.out.println("Selected"+langDropdown.getFirstSelectedOption().getText());
        langDropdown.selectByIndex(1);
        System.out.println("Selected "+langDropdown.getFirstSelectedOption().getText());
        langDropdown.selectByIndex(0);
        langDropdown.selectByIndex(3);
        langDropdown.selectByIndex(4);

        System.out.println("Selected "+langDropdown.getFirstSelectedOption().getText());

        //get all selected options
        List<WebElement> allSelectedOptions = langDropdown.getAllSelectedOptions();
        for (WebElement option : allSelectedOptions) {
            System.out.println(option.getText());
        }

        //deselect all options
        langDropdown.deselectAll();


    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");

        //clear before sendKeys
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.cssSelector("#tinymce")).clear();
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith");

        //goes back to first frame(main html)
        //goes back to first frame, useful when we have switched multiple frames
        driver.switchTo().defaultContent();

        //2.Switching with INDEX
        driver.switchTo().frame(0);
        Thread.sleep(1000);

        //clear before sendKeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith with INDEX");

        //second way to switch parent
        driver.switchTo().parentFrame();

        //3.Switching with WebElement
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElement);

        //clear before sendKeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith with WebElement");
    }

    @Test
    public void test3(){
        driver.get("http://practice.cybertekschool.com/nested_frames");
        //*****(-we can only switch one at a time, cannot switch to grandchild directly.)
        //switching to frame top
        driver.switchTo().frame("frame-top");
        //top has 3 frame under left middle and right
        //switch to middle
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());

        //*****(-cannot switch to siblings, only parent to child)
        //goes back to top frame
        driver.switchTo().parentFrame();

        //switching right with index
        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        //go to main html to switch bottom
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.tagName("body")).getText());

    }
}
