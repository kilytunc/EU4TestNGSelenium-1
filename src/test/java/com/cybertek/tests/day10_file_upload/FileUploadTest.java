package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {

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
    public void test1(){

        driver.get("http://practice.cybertekschool.com/upload");

        //locating choose file button
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        //sending file
        chooseFile.sendKeys("C:\\Users\\ZdN\\Desktop\\file.txt");
        //clicking upload button
        driver.findElement(By.id("file-submit")).click();

        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(),"file.txt");
    }

    @Test //with dynamic way
    public void test2(){
        driver.get("http://practice.cybertekschool.com/upload");

        //locating choose file button
        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/textfile.txt";
        String fullPath = projectPath+"/"+filePath;

        //sending file
        chooseFile.sendKeys(fullPath);

        //clicking upload button
        driver.findElement(By.id("file-submit")).click();

        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(),"textfile.txt");

    }
}
