package com.bitrix24.step_definitions;

import com.bitrix24.utils.BasePage;
import com.bitrix24.utils.Pages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.time.LocalDateTime;

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
        Assert.assertEquals(expected,actual);
    }
}
