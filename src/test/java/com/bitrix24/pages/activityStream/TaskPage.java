package com.bitrix24.pages.activityStream;

import com.bitrix24.utils.*;
import javafx.scene.control.DatePicker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import java.lang.invoke.SwitchPoint;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.bitrix24.utils.Driver.getDriver;

public class TaskPage extends BasePage {
    @FindBy(id = "feed-add-post-form-tab-tasks")
    public WebElement taskModuleButton;
    @FindBy(id = "task-edit-title")
    public WebElement inputTaskName;
    @FindBy(xpath = "//button[@id='blog-submit-button-save' and contains(text(),'Send')]")
    public WebElement sendButton;
    @FindBy(xpath = "//button[@id='blog-submit-button-cancel' and contains(text(),'Cancel')]")
    public WebElement cancelButton;
    @FindBy(css = "div[class='popup-window-angly popup-window-angly-top']")
    public WebElement addMention;
    @FindBy(css = "span[class=\"tasks-task-mpf-link\"]")
    public WebElement checklist;
    @FindBy(css = "input[id='tasks-task-priority-cb']")
    public WebElement highPriorityCheckbox;
    @FindBy(css = "div[class='task-additional-alt-more']")
    public WebElement moreButton;
    @FindBy(xpath = "//*[@id=\"blogPostEditCreateTaskPopup_content\"]/div/div[1]")
    public WebElement taskCreatedwindow;
    @FindBy(xpath = "//*[@id=\"bx-component-scope-lifefeed_task_form\"]/div/div[1]/div[1]/div[2]/input")
    public WebElement clickOnTextBox;

    //***Attach file locators
    @FindBy(css = "div.task-info div.diskuf-uploader input")
    public WebElement getUploadFromComputer;
    @FindBy (xpath= "/html/body ")
    public WebElement inputMessageBox;
    @FindBy (xpath = "//*[@id=\"bx-b-link-task-form-lifefeed_task_form\"]/span/i")
    public WebElement attachLink;
    @FindBy (id = "bx-b-uploadfile-task-form-lifefeed_task_form")
    public WebElement uploadFiles;
    @FindBy(xpath = "//*[@id=\"linklifefeed_task_form-href\"]")
    public WebElement enterLinkBox;
    @FindBy(xpath = "//*[@id=\"undefined\"]")
    public WebElement saveLinkButton;
    @FindBy(className = "diskuf-label-icon")
    public  WebElement attachedFileIcon;
    @FindBy(className = "f-wrap")
    public List<WebElement> attachedFilenameList;

    // *** deadline locators
    @FindBy(css = "input[data-bx-id='datepicker-display']")
    public WebElement deadLineButton;
    @FindBy(css = "a.bx-calendar-top-year")
    public WebElement yearButton;
    @FindBy(css = "a.bx-calendar-top-month")
    public WebElement monthButton;
    @FindBy(css = "a.bx-calendar-button-select")
    public WebElement dateSelectButton;
    @FindBy(css = "input.bx-calendar-year-input")
    public WebElement yearTextbox;
    @FindBy(css = "input[name='ACTION[0][ARGUMENTS][data][DEADLINE]']")
    public WebElement deadlineLabel;


//**Create task Methods
    public void navigatetoTask(){
        taskModuleButton.click();
    }

    public void enterTaskTittle(String value) {
        clickOnTextBox.click();
        clickOnTextBox.sendKeys(value);
    }

    public void clickSendButton() {
        sendButton.click();
        }
        public boolean verifyCreateMessage(){
            System.out.println("Message "+taskCreatedwindow.getText());
        return  taskCreatedwindow.isDisplayed();
    }
  
    //**Attach file and Link methods
    public void attachFile(String filename){
        String filepath = System.getProperty("user.dir") + ConfigurationReader.getProperty("filepath") + filename;
        uploadFiles.click();
        BrowserUtils.waitPlease(2);
        getUploadFromComputer.sendKeys(filepath);
        BrowserUtils.waitPlease(4);
    }

    public List<String> getAttachedFileList(){
        List<String> filelist = new ArrayList<>();
        for (WebElement each:attachedFilenameList) {
            filelist.add(each.getText());
        }
        return filelist;
    }

    public void verifyUploadedFilesIcon(){

    }
    public void attachLink(String value) {
        attachLink.click();
        enterLinkBox.sendKeys(value);
        saveLinkButton.click();
    }

    public String verifyLinkIsAttached(String value) {

        getDriver().switchTo().frame("bx-editor-iframe");
        String actualLinkText = getDriver().findElement(By.cssSelector("a[href='"+value+"']")).getText();
        //String actualREsalt = inputMessageBox.getText();
        return actualLinkText;
}

    // *** DEADLINE METHODS
    /**
     * click on the Deadline box to set a date
     */
    public void clickDeadlineButton() {
        deadLineButton.click();
    }

    /**
     * select the date from the calendar
     * @param datetimestr
     */
    public void selectDeadlineDate(String datetimestr) {

        // make am pm Uppercase to be able to parse into datetime
        datetimestr = datetimestr.replace("am", "AM").replace("pm","PM");
        // parse the date string into LocalDateTime using DateTimeFormatter
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        LocalDateTime ldt = LocalDateTime.parse(datetimestr, dtf);

        // date parts for the selected date
        int month = ldt.getMonthValue();
        int year = ldt.getYear();
        int day = ldt.getDayOfMonth();

        // date parts for the current date
        int currentYear = LocalDate.now().getYear();
        int currentMonth = LocalDate.now().getMonthValue();
        int currentDay = LocalDate.now().getDayOfMonth();

        // if year to select is not current year than click on the year
        if(year != currentYear){
            yearButton.click();
            BrowserUtils.waitPlease(2); // pause for demo
            // if year to select is within 3 year range with current year than click on the direct link
            if(Math.abs(year - currentYear) <= 3){
                String yearLink = "span.bx-calendar-year-number[data-bx-year='" + year + "']";
                Driver.getDriver().findElement(By.cssSelector(yearLink)).click();
            }
            // if year not within 3 year than key in
            yearTextbox.sendKeys(year + "");
            BrowserUtils.waitPlease(2); // pause for demo
        }

        // if month is different than click on month and select from the list
        if(month != currentMonth){
            monthButton.click();
            BrowserUtils.waitPlease(2); // pause for demo
            //Locator for month
            String monthLocator = "span[data-bx-month='" + (month - 1) + "']";
            Driver.getDriver().findElement(By.cssSelector(monthLocator)).click();
            BrowserUtils.waitPlease(2); // pause for demo
        }

        if(day != currentDay){
            //locator for day
            //pick non-hidden day hidden days belong to prior and next month
            String dayLocator = "//a[contains(@class,'bx-calendar-cell') and text()='" + day + "' and not(contains(@class,'bx-calendar-date-hidden'))]";
            Driver.getDriver().findElement(By.xpath(dayLocator)).click();
            BrowserUtils.waitPlease(2); // pause for demo
        }
    }

    /**
     * Click on the Select button in Calendar to set the Deadline date
     */
    public void clickDeadlineSelectButton() {
        dateSelectButton.click();
        BrowserUtils.waitPlease(2); // pause for demo
    }

    /**
     * returns the Deadline date label value
     * @return
     */
    public String getDeadline(){
        return deadlineLabel.getAttribute("value");
    }
}

//    // *** task module locators
//    @FindBy(css = "thead.main-grid-header")
//    public WebElement tableHead;
//    @FindBy(css = "thead.main-grid-header th[data-name='TITLE']")
//    public WebElement nameHeader;
//    @FindBy(xpath = "//*[@id=\"feed-add-post-form-tab-tasks\"]/span")
//    public WebElement taskModuleButton;
//    @FindBy (css ="span[id='bx-b-uploadfile-task-form-lifefeed_task_form']")
//    public WebElement uploadFiles;
//    @FindBy(xpath = "//*[@id=\"diskuf-selectdialog-wrgLCp0\"]/div[2]/table/tbody/tr[1]/td[1]/div/span")
//    public WebElement getUploadFromComputer;