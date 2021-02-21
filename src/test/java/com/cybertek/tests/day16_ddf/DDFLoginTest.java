package com.cybertek.tests.day16_ddf;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {

    @DataProvider Object [][] userData(){

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        return qa3short.getDataArrayWithoutFirstRow();

    }

    @Test(dataProvider = "userData")
    public void login(String username, String password, String firstname, String lastname){

        extentLogger = report.createTest("Test"+firstname+" "+lastname);
        LoginPage loginPage = new LoginPage();

        extentLogger.info("login with valid credentials");
        loginPage.login(username,password);

        DashboardPage dashboardPage = new DashboardPage();

        extentLogger.info("Verify fullname");
        Assert.assertEquals(dashboardPage.getUserName(),firstname+" "+lastname);

        extentLogger.pass("PASSED");

    }



}
