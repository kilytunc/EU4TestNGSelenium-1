package com.cybertek.tests.day02_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

        //getting title with selenium
        System.out.println(driver.getTitle());

        // shortcut for creating variable
        //ALT + ENTER + ENTER
        String title = driver.getTitle();

        // shortcut for printing
        // soutv + ENTER
        System.out.println("title = " + title);

        // getCurrentUrl() ---> get the url from browser
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //getPageSource() ---> get the source of the page
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);

    }

}
