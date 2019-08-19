package com.bitrix24.step_definitions;

import com.bitrix24.utils.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CreateTaskStepDefinition {
    Pages  page = new Pages();

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








}
