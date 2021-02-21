package com.cybertek.tests.day01_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {
    public static void main(String[] args) {
//        //we have to enter this line every time we want to open chrome
//        WebDriverManager.chromedriver().setup();
//
//        //Webdriver represent the browser
//        //we are creating driver for chrome browser
//        //new ChromeDriver ---> this part will open a blank chrome browser
//        WebDriver driver = new ChromeDriver();
//
//        // .get(url) method used to for navigation to page
//        driver.get("https://www.cybertekschool.com/");

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.mozilla.org/en-US/");
    }
}
