package com.cybertek.tests.day11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }


    @AfterMethod

    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void printTable(){

        WebElement table1 = driver.findElement(By.id("table1"));

        System.out.println(table1.getText());

        Assert.assertTrue(table1.getText().contains("John"));


    }

    @Test
    public void getAllHeaders(){

        // how many columns we have ?

        List<WebElement> elements = driver.findElements(By.xpath("//*[@id='table1']//th"));
        System.out.println("elements.size() = " + elements.size());

        for (WebElement element : elements) {
            System.out.println(element.getText());
        }


    }

    @Test
    public void printTableSize(){
        // how many columns we have?
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id='table1']//th"));
        System.out.println("elements.size() = " + elements.size());

        //how can we find number of rows
        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//*[@id='table1']//tr"));
        System.out.println("allRowsWithHeader.size() = " + allRowsWithHeader.size());

        //how can we find number of rows except headers
        List<WebElement> allRows = driver.findElements(By.cssSelector("[id='table1']>tbody>tr"));
        System.out.println("allRows.size() = " + allRows.size());
    }

    @Test
    public void getRow(){

        //print the second row information
        WebElement secondRowInfo = driver.findElement(By.cssSelector("[id='table1']>tbody>:nth-of-type(2)"));
        System.out.println("secondRowInfo.getText() = " + secondRowInfo.getText());

        //get all rows dynamically
        //1.find number of rows
        List<WebElement> Rows = driver.findElements(By.cssSelector("[id='table1']>tbody>tr"));
        for (int i = 1; i <= Rows.size(); i++) {
            WebElement row = driver.findElement(By.cssSelector("[id='table1']>tbody>:nth-of-type("+i+")"));
            System.out.println("row["+i+"] = " + row.getText());
        }


    }

    @Test
    public void getAllCellInOneRow(){

        List<WebElement> allCellsInOneRow = driver.findElements(By.cssSelector("[id='table1']>tbody>:nth-of-type(1)>td"));
        for (WebElement rowInfo : allCellsInOneRow) {
            System.out.println("rowInfo.getText() = " + rowInfo.getText());
        }

    }

    @Test
    public void getASingleCellByIndex(){
        WebElement element = driver.findElement(By.cssSelector("[id='table1']>tbody>:nth-of-type(2)>td:nth-of-type(2)"));
        // xpath = //table[@id='table1']/tbody/tr[2]/td[2]

        System.out.println(element.getText());
    }

    @Test
    public void printallCellByIndex(){

        int colNumber = calcCalNum();
        int rowNumber = calcRowNum();

        for (int i = 1; i <= colNumber; i++) {
            for (int j = 1; j < rowNumber; j++) {
                String xpathText = "//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]";
                WebElement element = driver.findElement(By.xpath(xpathText));
                System.out.println("xpathText["+i+"]["+j+"] = " + xpathText);
                System.out.println("element["+i+"]["+j+"] = " + element.getText());
            }

        }

    }

    private int calcRowNum() {
        return driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td")).size();
    }

    private int calcCalNum() {
        return driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
    }

    @Test
    public void getCellInRelationToAnotherCellInSameRow(){
        String name = "John";
        String xpath = "//table[@id='table1']//td[.='John']/../td[3]";
        WebElement element = driver.findElement(By.xpath(xpath));
        System.out.println(element.getText());
    }
}
