package com.bitrix24.step_definitions;

import com.bitrix24.utils.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CreateTaskStepDefinition {
    Pages  page = new Pages();
    @When("user navigates to {string}")
    public void userNavigatesTo(String value) {

    }

    @Given("user enters task name {string}")
    public void user_enters_task_name(String value) {
    page.taskPage().enterTaskTittle(value);
    }

    @Given("user clicks on Send button")
    public void user_clicks_on_Send_button() {
    page.taskPage().clickSendButton();
    }

    @Then("system should display new task")
    public void system_should_display_new_task() {
    page.taskPage().verifyCreateMessage();
    }


    @When("user navigates to {string} in {string} page")
    public void user_navigates_to_in_page(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("User clicks on {string} button")
    public void user_clicks_on_button(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("User click on {string} and select a file")
    public void user_click_on_and_select_a_file(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("System should upload the file or image")
    public void system_should_upload_the_file_or_image() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

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
