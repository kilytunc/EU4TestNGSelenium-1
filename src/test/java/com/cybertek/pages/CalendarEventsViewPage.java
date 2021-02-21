package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsViewPage extends BasePage{

    public CalendarEventsViewPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//label[.='Title']/following-sibling::div[@class='controls']/div")
    public WebElement title;

    @FindBy(xpath = "//div[@class='control-label html-property']/p/span")
    public WebElement description;

    @FindBy(xpath = "//label[.='Start']/following-sibling::div[@class='controls']/div")
    public WebElement start;

    @FindBy(xpath = "//label[.='End']/following-sibling::div[@class='controls']/div")
    public WebElement end;

    @FindBy(xpath = "//label[.='All-day event']/following-sibling::div[@class='controls']/div")
    public WebElement allDayEvent;

    @FindBy(css = "[class='calendar-event-organizer']>a[href='/user/view/209']")
    public WebElement organizer;

    @FindBy(xpath = "//label[.='Recurrence']/following-sibling::div/div")
    public WebElement recurrence;

    @FindBy(xpath = "//label[.='Call via Hangout']/following-sibling::div[@class='controls']/div")
    public WebElement callViHangout;
}
