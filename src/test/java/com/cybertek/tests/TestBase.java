package com.cybertek.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    //this class used for starting nad building reports
    protected ExtentReports report;
    //this class is used to HTML report file
    protected ExtentHtmlReporter htmlReporter;
    //this will define a test, enables adding logs, authors, test steps
    protected ExtentTest extentLogger;
    protected String url;

    @BeforeTest
    public void setUpTest(){

        //initialize the class
        report = new ExtentReports();

        //create a report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath+"/test-output/report.html";

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("Vytrack Smoke Test");

        //set entironment information
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));

    }
    @BeforeMethod
    @Parameters("env")
    public void setUpMethod(@Optional String env){
        System.out.println("env = " + env);
        //if env variable is null use default url
        if(env==null){
            url=ConfigurationReader.get("url");
        }else{
            url=ConfigurationReader.get(env+"_url");
        }
        //if it is not null, choose env based on value
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);
        driver.get(url);
    }


    //ITestResult class describes the result of a test in TestNG
    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        //if test fails
        if (result.getStatus()==ITestResult.FAILURE){

            //record the name of failed test cases
            extentLogger.fail(result.getName());

            //take the screenshot and return location of screenshot

            String screenShotPath = BrowserUtils.getScreenshot(result.getName());

            //add your screenshot to your report
            extentLogger.addScreenCaptureFromPath(screenShotPath);

            //capture exception and put inside the report
            extentLogger.fail(result.getThrowable());



        }



        //Thread.sleep(2000);
        Driver.closeDriver();
    }

    @AfterTest
    public void tearDownTest(){

        //this is when report is actually created
        report.flush();

    }
}
