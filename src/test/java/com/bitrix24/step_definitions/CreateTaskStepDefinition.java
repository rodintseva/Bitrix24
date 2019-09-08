package com.bitrix24.step_definitions;

import com.bitrix24.utils.BasePage;
import com.bitrix24.utils.Pages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateTaskStepDefinition {
    Pages page = new Pages();

    //***Steps to create Task
    @When("user navigates to Task module")
    public void userNavigatesToTaskModule() {
        page.taskPage().navigatetoTask();
    }

    @Given("user enters task name {string}")
    public void user_enters_task_name(String value) {
        page.taskPage().enterTaskTittle(value);
    }

    @Given("user clicks on Send button")
    public void user_clicks_on_Send_button() {
        page.taskPage().clickSendButton();
    }

    @Then("System should display \"Task has been created\" message")
    public void system_should_display_new_task() {
        page.taskPage().verifyCreateMessage();
    }

    // *** Steps to attach file
    @And("user clicks on upload file button and attaches file {string}")
    public void user_clicks_on_upload_file_button_and_attaches_file(String filename) {
        page.taskPage().attachFile(filename);
    }

    @Then("system should display the attached filename {string} or {string}")
    public void system_should_display_the_attached_file(String expected1, String expected2) {
        List<String> fileList = page.taskPage().getAttachedFileList();
        int lastFileIndex = fileList.size() - 1;
        String actualFilename = fileList.get(lastFileIndex);

        // extract the filename from uploaded filename or expected2 if there is a number
        Pattern pattern = Pattern.compile("^(.+?)( \\([\\#\\d]\\))+(\\..*)?$");
        String expected2file = "";

        // remove paranthesis (#) part from expected
        Matcher me = pattern.matcher(expected2);
        while(me.find()){
            expected2file =  me.group(1) + me.group(3);
        }

        //remove number (#) part from actual
        Matcher ma = pattern.matcher(actualFilename);
        while(ma.find()){
            actualFilename =  ma.group(1) + ma.group(3);
        }

        Assert.assertTrue(actualFilename.equals(expected1) || actualFilename.equals(expected2file));
    }

    // *** Steps to set deadline
    @And("clicks on Calendar under Deadline")
    public void click_on_Calendar_under_Deadline() {
        page.taskPage().clickDeadlineButton();
    }

    @And("selects date {string}")
    public void select_date(String datestr) {
        page.taskPage().selectDeadlineDate(datestr);
    }

    @And("clicks on Select button")
    public void click_on_Select_button() {
        page.taskPage().clickDeadlineSelectButton();
    }

    @Then("system should display date {string}")
    public void system_should_display_date(String expected) {

        String actual = page.taskPage().getDeadline();
        Assert.assertEquals(expected, actual);
    }
}
