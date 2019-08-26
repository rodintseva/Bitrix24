package com.bitrix24.step_definitions;

import com.bitrix24.utils.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class VerifyTittleStepDefenition {

    Pages page = new Pages();
    @Then("the title should be {string}")
    public void theTitleShouldBe(String module) {
    Assert.assertEquals(module,page.taskPage().returnPageTitle(module));
    }

    @When("user clicks on {string}")
    public void userClicksOn(String module) {
        page.taskPage().navigateToModule(module);
    }

    @Given("user logs in as {string}")
    public void userLogsInAs(String user) {
        page.loginPage().loginAyden(user);
    }
}
