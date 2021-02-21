package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {

    @Test
    public void verifyContact(){

        extentLogger = report.createTest("Contact Info Verification");
        extentLogger.info("username: salesmanager120");
        extentLogger.info("password: UserUser123");
        extentLogger.info("Login as a Sales Manager");

        LoginPage loginPage = new LoginPage();
        extentLogger.info("Navigate to --> Customers > Contacts");
        loginPage.login("salesmanager120","UserUser123");

        new DashboardPage().navigateToModule("Customers","Contacts");

        ContactsPage contactsPage = new ContactsPage();

        extentLogger.info("Click on mbrackstone9@example.com");
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        ContactInfoPage contactInfoPage = new ContactInfoPage();

        String expectedFullName = "Mariam Brackstone";
        String actualFullName = contactInfoPage.fullName.getText();

        extentLogger.info("Verify fullName is: "+expectedFullName);
        Assert.assertEquals(actualFullName ,expectedFullName,"Verify the name");
        extentLogger.info("Verify email is: mbrackstone9@example.com");
        Assert.assertEquals(contactInfoPage.email.getText(),"mbrackstone9@example.com","verify email");
        extentLogger.info("Verify phone is: +18982323434");
        Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434","verify phone number");

        extentLogger.pass("PASSED");
    }

}
