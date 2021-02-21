package com.cybertek.tests.TestCases;

import com.cybertek.pages.*;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vytrack_HW extends TestBase {

    public void goToCalendarEventsPage(){
        //name of test
        extentLogger = report.createTest("Vytrack HW Test");
        extentLogger.info("1. Go to “https://qa1.vytrack.com/\"\n" +
                "2. Login as a store manager");
        new LoginPage().loginAsStoreManager();
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Navigate to “Activities -> Calendar Events”");
        dashboardPage.navigateToModule("Activities","Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();
    }


    @Test
    public void testCase01(){

        goToCalendarEventsPage();
        extentLogger.info("Verify that page subtitle \"Options\" is displayed");
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Options')]")).getText(),"Options");
        extentLogger.info("PASSED");

    }
    @Test
    public void testCase02(){

        goToCalendarEventsPage();
        extentLogger.info("Verify that page number is equals to \"1\"");
        Assert.assertEquals(driver.findElement(By.cssSelector("[type='number']")).getAttribute("Value"),"1");
        extentLogger.info("PASSED");
    }

    @Test
    public void testCase03(){

        goToCalendarEventsPage();
        extentLogger.info("Verify that view per page number is equals to\n" +
                "\"25\"");
        Assert.assertEquals(driver.findElement(By.cssSelector("[class='btn dropdown-toggle ']")).getText(),"25");
        extentLogger.info("PASSED");
    }

    @Test
    public void testCase04() throws InterruptedException {

        goToCalendarEventsPage();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        String totalPageNumber = calendarEventsPage.totalPageNumberText.getText();


        //Thread.sleep(2000);
        calendarEventsPage.currentPageNumberInput.sendKeys(totalPageNumber+ Keys.ENTER);
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        int pageNumber = Integer.parseInt(totalPageNumber.substring(totalPageNumber.indexOf(" ") + 1, totalPageNumber.lastIndexOf(" ")));

        String recordNumberString = calendarEventsPage.recordsNumberText.getText();
        int recordNumber = Integer.parseInt(recordNumberString.substring(recordNumberString.indexOf(" ",6)+1,recordNumberString.lastIndexOf(" ")));



        int rowPerPage = Integer.parseInt(calendarEventsPage.viewPerPageButton.getText());
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        List<WebElement> tableRows = driver.findElements(By.xpath("//table/tbody/tr"));
        System.out.println("pageNumber = " + pageNumber);
        System.out.println("recordNumber = " + recordNumber);
        System.out.println("rowPerPage = " + rowPerPage);
        System.out.println("tableRows.size() = " + tableRows.size());
        extentLogger.info("Verify that number of calendar events (rows in\n" +
                "the table) is equals to number of records");
        Assert.assertEquals(recordNumber,((pageNumber-1)*rowPerPage)+ tableRows.size());
        extentLogger.info("PASSED");
    }

    @Test
    public void testCase00() throws InterruptedException {
        /*
1. Go to "https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to "Activities -> Calendar Events"
4. Verify that number of calendar events (rows in
the table) is equals to number of records
Hint: In HTML, <table> tag represents table, <thread> - table header, <tr> tag represents table row element,
<th> table header cell and <td> table data.
Css selector: table > tr
         */
            extentLogger= report.createTest("View Per Page Verification");
            LoginPage loginPage = new LoginPage();
            extentLogger.info("Login as a store manager");
            loginPage.loginAsStoreManager();
            DashboardPage dashboardPage = new DashboardPage();
            extentLogger.info("Navigate to Activities -> Calendar Events");
            dashboardPage.navigateToModule("Activities", "Calendar Events");
            //dashboardPage.waitUntilLoaderScreenDisappear();
            //Thread.sleep(2000);
            CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
            calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(calendarEventsPage.recordsNumberText,10);
            extentLogger.info("Get number of records");
            String records = calendarEventsPage.recordsNumberText.getText();

        System.out.println(records);
            records = records.replace("Total Of ","").replace(" Records","");
            int numberOfRecords = Integer.parseInt(records);
            extentLogger.info("Get all the number of rows in all pages");
            String numberOfPage = calendarEventsPage.numberOfPages.getText();
            numberOfPage =numberOfPage.replace("Of ","").replace(" |","");
            //numberOfPage= numberOfPage.replace(" |","");
            calendarEventsPage.numberOfPageInput.sendKeys(numberOfPage+ Keys.ENTER);
            //Thread.sleep(2000);
        calendarEventsPage.waitUntilLoaderScreenDisappear();
            List<WebElement> numberOfRowsLastPage = driver.findElements(By.cssSelector("table>tbody>tr"));
            int numberOfTotalRows = ((Integer.parseInt(numberOfPage)-1)*25)+numberOfRowsLastPage.size();
            System.out.println("numberOfRowsLastPage.size() = " + numberOfRowsLastPage.size());
            System.out.println("numberOfTotalRows = " + numberOfTotalRows);
            extentLogger.info("Verify that number of calendar events (rows in the table) is equals to number of records");
            Assert.assertEquals(numberOfRecords, numberOfTotalRows, "Verify number of total Rows with number of records");
            extentLogger.info("PASSED");


    }

    @Test
    public void testCase05(){

        goToCalendarEventsPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.topCheckBoxButton.click();

        List<WebElement> checkBoxes = driver.findElements(By.xpath("//tbody/tr/td/input"));
        extentLogger.info("Verify that all calendar events were selected");
        for (WebElement checkBox : checkBoxes) {
            Assert.assertTrue(checkBox.isSelected());
        }
        extentLogger.info("PASSED");
    }

    @Test
    public void testCase06() throws InterruptedException {

        goToCalendarEventsPage();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        //calendarEventsPage.waitUntilLoaderScreenDisappear();

        calendarEventsPage.titleColumnHeader.click();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        String totalPageNumber = calendarEventsPage.totalPageNumberText.getText();
        int pageNumber = Integer.parseInt(totalPageNumber.substring(totalPageNumber.indexOf(" ") + 1, totalPageNumber.lastIndexOf(" ")));



        //Thread.sleep(2000);
        calendarEventsPage.currentPageNumberInput.sendKeys(pageNumber+"" + Keys.ENTER);
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        loop1 : for (int i = pageNumber; i >= 1 ; i--) {
            //calendarEventsPage.waitUntilLoaderScreenDisappear();
            //Thread.sleep(2000);



            List<WebElement> titleElements = driver.findElements(By.xpath("//tbody/tr/td[2]"));

            for (WebElement titleElement : titleElements) {

                if (titleElement.getText().toLowerCase().charAt(0)=='t'){
                    List<WebElement> tableRows = driver.findElements(By.xpath("//tbody/tr"));
                for (int j = 1; j <= tableRows.size(); j++) {

                    calendarEventsPage.waitUntilLoaderScreenDisappear();
                    //Thread.sleep(2000);

                    if (driver.findElement(By.xpath("//tbody/tr["+j+"]/td[2]")).getText().equals("Testers meeting") &&
                            driver.findElement(By.xpath("//tbody/tr["+j+"]/td[3]")).getText().equals("Marcella Huels") &&
                                driver.findElement(By.xpath("//tbody/tr["+j+"]/td[4]")).getText().equals("Nov 27, 2019, 9:30 AM")
                            )
                    {

                        extentLogger.info("Select “Testers meeting”");
                        driver.findElement(By.xpath("//tbody/tr["+j+"]/td[4]")).click();

                        CalendarEventsViewPage viewPage = new CalendarEventsViewPage();
                        viewPage.waitUntilLoaderScreenDisappear();

                        List<String> expectedInformation = new ArrayList<>(Arrays.asList("Testers meeting","This is a a weekly testers meeting",
                                "Nov 27, 2019, 9:30 AM","Nov 27, 2019, 10:30 AM","No","Marcella Huels","Weekly every 1 week on Wednesday","No"));
                        viewPage.waitUntilLoaderScreenDisappear();
                        List<String> actualInformation = new ArrayList<>(Arrays.asList(viewPage.title.getText(),viewPage.description.getText(),
                                viewPage.start.getText(),viewPage.end.getText(),viewPage.allDayEvent.getText(),viewPage.organizer.getText(),
                                viewPage.recurrence.getText(), viewPage.callViHangout.getText()));
                        System.out.println(actualInformation);
                        System.out.println(expectedInformation);
                        extentLogger.info("Verify that following data is displayed:");
                        Assert.assertEquals(actualInformation,expectedInformation);
                        break loop1;

                    }
                  }
                }
            }

            driver.findElement(By.cssSelector("[data-grid-pagination-direction='prev']")).click();
            calendarEventsPage.waitUntilLoaderScreenDisappear();
        }
        extentLogger.info("PASSED");
    }
}
