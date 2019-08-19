package com.bitrix24.step_definitions;

import com.bitrix24.utils.Pages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CreateTaskStepDefinition {
    Pages  page = new Pages();
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

//***Steps to attach Link
        @Then("User clicks on upload file button attaches file located at {string}")
        public void userClicksOnUploadFileButtonAttachesFileLocatedAt(String value) {
        page.taskPage().attachFile(value);
        }
         @Then("System should display attached file")
         public void systemShouldDisplayAttachedFile() {
            page.taskPage().verifyUploadedFilesIcon();
    }

        @And("User clicks on Link button and upload the link {string}")
        public void userClicksOnLinkButtonAndUploadTheLink(String value) {
        page.taskPage().attachLink(value);
        }
        @Then("System should upload link {string}")
        public void systemShouldUploadLink(String expected) {
        Assert.assertEquals(expected, page.taskPage().verifyLinkIsAttached().toString());
        }
//***Steps to set deadline
    @When("Click on Calendar under Deadline")
    public void click_on_Calendar_under_Deadline() {
        page.taskPage().clickDeadlineButton();
    }

    @When("Click on a date and time")
    public void click_on_a_date_and_time() {
        page.taskPage().selectDeadlineDate("8/15/2019");
    }

    @When("Click on Select button")
    public void click_on_Select_button() {
        page.taskPage().clickDeadlineSelectButton();
    }

    @Then("System should display the selected date time")
    public void system_should_display_the_selected_date_time() {
        Assert.assertTrue(page.taskPage().verifyCreateMessage());
    }



}
