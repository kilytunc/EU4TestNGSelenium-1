package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "(//label[@class='dib'])[2]")
    public WebElement totalPageNumberText;

    @FindBy(css = "[type='number']")
    public WebElement currentPageNumberInput;

    @FindBy(xpath = "(//label[@class='dib'])[3]")
    public WebElement recordsNumberText;

    @FindBy(css = "[class='btn dropdown-toggle ']")
    public WebElement viewPerPageButton;

    @FindBy(xpath = "(//button[@class='btn btn-default btn-small dropdown-toggle']/input)[1]")
    public WebElement topCheckBoxButton;

    @FindBy(xpath = "//*[.='Title']")
    public WebElement titleColumnHeader;

    @FindBy(xpath = "//div/label[@class='dib'][3]")
    public WebElement numberOfRecords;
}
