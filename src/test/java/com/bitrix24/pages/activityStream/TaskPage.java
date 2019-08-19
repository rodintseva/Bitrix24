package com.bitrix24.pages.activityStream;

import com.bitrix24.utils.BasePage;
import com.bitrix24.utils.BrowserUtils;
import com.bitrix24.utils.Driver;
import com.bitrix24.utils.Pages;
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
    @FindBy(xpath = "//*[@id=\"feed-add-post-form-tab-tasks\"]/span")
    public WebElement taskModuleButton;
    @FindBy(xpath = "//*[@id=\"blogPostEditCreateTaskPopup_content\"]/div/div[1]")
    public WebElement taskCreatedwindow;
    @FindBy(xpath = "//*[@id=\"bx-component-scope-lifefeed_task_form\"]/div/div[1]/div[1]/div[2]/input")
    public WebElement clickOnTextBox;

        public void navigatetoTask(){
        taskModuleButton.click();
        }
        public void enterTaskTittle(String value){
         clickOnTextBox.click();
        clickOnTextBox.sendKeys(value);
        }
        public void clickSendButton(){
        sendButton.click();
        }
        public boolean verifyCreateMessage(){
            System.out.println("Message "+taskCreatedwindow.getText());
        return  taskCreatedwindow.isDisplayed();
}
}



