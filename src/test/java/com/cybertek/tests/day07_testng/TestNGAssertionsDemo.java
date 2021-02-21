package com.cybertek.tests.day07_testng;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @Test
    public void test1(){
        System.out.println("Test1");
        Assert.assertEquals("title","title");
    }

    @Test
    public void test2(){
        System.out.println("Test2");
        Assert.assertEquals("url","url");
    }

    @Test
    public void test3(){
        String expectedTitle = "Cyb";
        String actualTitle = "Cybertek";

        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"Verify title starts with Cyb");
    }

    @Test
    public void test4(){
        //verify email contains @ sign
        String email ="mikesmith@.com";
        Assert.assertTrue(email.contains("@"),"verify email contains @");
    }

    @Test
    public void test5(){
        Assert.assertFalse(1<0);
    }

    @Test
    public void test6(){
        Assert.assertNotEquals("url","Url");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("Close Browser");
    }

}
