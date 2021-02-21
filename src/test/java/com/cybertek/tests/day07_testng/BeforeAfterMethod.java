package com.cybertek.tests.day07_testng;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @BeforeClass
    public void setUpClass(){
        System.out.println("--Before Class-");
    }

    @BeforeMethod
    public void setUP(){
        System.out.println("WebDriver,Opening Browser");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("Some Reporting Code Here");
        System.out.println("--After Class--");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Close Browser");
    }

    //@Ignore to ignore this method
    @Test
    public void test1(){
        System.out.println("First Test Case");
    }
    @Test
    public void test2(){
        System.out.println("Second Test Case");
    }
    @Test
    public void test3(){
        System.out.println("Third Test Case");
    }

}
