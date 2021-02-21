package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    @Test
    public void test1(){

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        String expectedSubtitle = "Quick Launchpad";

        DashboardPage dashboardPage = new DashboardPage();

        String actualSubtitle = dashboardPage.getPageSubTitle();

        Assert.assertEquals(actualSubtitle,expectedSubtitle,"verify subtitle");

        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        BrowserUtils.waitFor(2);

        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events","Verify subtitle Calendar Events");

    }








}
