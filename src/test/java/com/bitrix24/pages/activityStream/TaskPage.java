package com.bitrix24.pages.activityStream;

import com.bitrix24.utils.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskPage extends BasePage {
    @FindBy(id = "feed-add-post-form-tab-tasks")
    public WebElement activityStream;
    @FindBy(id = "task-edit-title")
    public WebElement inputTaskName;
    @FindBy (xpath= "//button[@id='blog-submit-button-save' and contains(text(),'Send')]")
    public WebElement sendButton;
    @FindBy (xpath= "//button[@id='blog-submit-button-cancel' and contains(text(),'Cancel')]")
    public WebElement cancelButton;
    @FindBy (css = "body[style='min-height: 84px;'] ")
    public WebElement inputMessageBox;
    @FindBy (css ="span[id='bx-b-uploadfile-task-form-lifefeed_task_form']")
    public WebElement uploadFiles;
    @FindBy (xpath = "//span[text()='Link']")
    public WebElement attachLink;
    @FindBy(css = "div[class='popup-window-angly popup-window-angly-top']")
    public WebElement addMention;
    @FindBy (css = "span[class=\"tasks-task-mpf-link\"]")
    public WebElement checklist;
    @FindBy (css = "input[id='tasks-task-priority-cb']")
    public WebElement highPriorityCheckbox;
    @FindBy (css = "div[class='task-additional-alt-more']")
    public WebElement moreButton;



}
