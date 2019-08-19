package com.bitrix24.pages.activityStream;

import com.bitrix24.utils.BasePage;
import com.bitrix24.utils.BrowserUtils;
import com.bitrix24.utils.Driver;
import com.bitrix24.utils.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaskPage extends BasePage {
    @FindBy(id = "feed-add-post-form-tab-tasks")
    public WebElement activityStream;
    @FindBy(id = "task-edit-title")
    public WebElement inputTaskName;
    @FindBy(xpath = "//button[@id='blog-submit-button-save' and contains(text(),'Send')]")
    public WebElement sendButton;
    @FindBy(xpath = "//button[@id='blog-submit-button-cancel' and contains(text(),'Cancel')]")
    public WebElement cancelButton;
//    @FindBy(css = "body[style='min-height: 84px;'] ")
    @FindBy(css = "input[data-bx-id='task-edit-title']")
    public WebElement inputMessageBox;
    @FindBy(css = "span[id='bx-b-uploadfile-task-form-lifefeed_task_form']")
    public WebElement uploadFiles;
    @FindBy(xpath = "//span[text()='Link']")
    public WebElement attachLink;
    @FindBy(css = "div[class='popup-window-angly popup-window-angly-top']")
    public WebElement addMention;
    @FindBy(css = "span[class=\"tasks-task-mpf-link\"]")
    public WebElement checklist;
    @FindBy(css = "input[id='tasks-task-priority-cb']")
    public WebElement highPriorityCheckbox;
    @FindBy(css = "div[class='task-additional-alt-more']")
    public WebElement moreButton;
    @FindBy(xpath = "//*[@id=\"feed-add-post-form-tab-tasks\"]/span")
    public WebElement taskModuleButton;
    @FindBy(xpath = "//*[@id=\"blogPostEditCreateTaskPopup_content\"]/div/div[1]")
    public WebElement taskCreatedwindow;

    // *** deadline locators
    @FindBy(css = "input[data-bx-id='datepicker-display']")
    public WebElement deadLineButton;
    @FindBy(css = "a.bx-calendar-top-year")
    public WebElement yearDropdown;
    @FindBy(css = "a.bx-calendar-top-month")
    public WebElement monthDropdown;
    @FindBy(css = "a.bx-calendar-button-select")
    public WebElement dateSelectButton;


    public void enterTaskTittle(String value) {
        inputMessageBox.sendKeys(value);
    }

    public void clickSendButton() {
        sendButton.click();
    }

    public boolean verifyCreateMessage() {
        return taskCreatedwindow.isDisplayed();
    }

    // *** deadline methods
    public void clickDeadlineButton() {
        deadLineButton.click();
    }

    public void selectDeadlineDate(String date) {
        waitUntilLoaderScreenDisappear();
        LocalDate ld = LocalDate.of(Integer.parseInt(date.substring(date.lastIndexOf("/") + 1)),
                Integer.parseInt(date.substring(0, date.indexOf("/"))),
                Integer.parseInt(date.substring(date.indexOf("/") + 1, date.lastIndexOf("/"))));

        String month = DateTimeFormatter.ofPattern("MMM").format(ld);
        int year = ld.getYear();
        int day = ld.getDayOfMonth();


        //locator for day
        //pick non-hidden day hidden days belong to prior and next month
        String dayLocator = "//a[contains(@class,'bx-calendar-cell') and text()='" + day + "' and not(contains(@class,'bx-calendar-date-hidden'))]";
//      BrowserUtils.waitForVisibility(endDate, 5);

        //select year
        new Select(yearDropdown).selectByVisibleText(year + "");
        //select month
        new Select(monthDropdown).selectByVisibleText(month);
        //select day
        Driver.getDriver().findElement(By.xpath(dayLocator)).click();
    }

    public void clickDeadlineSelectButton(){
        dateSelectButton.click();
    }

}



