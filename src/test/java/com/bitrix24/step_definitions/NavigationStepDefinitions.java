package com.bitrix24.step_definitions;

import com.bitrix24.utils.BasePage;
import com.bitrix24.utils.Driver;
import com.bitrix24.utils.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class NavigationStepDefinitions {

    Pages pages = new Pages();

    @Given("user logs in as {string}")
    public void user_logs_in_as(String role) {
        pages.loginPage().login(role);
    }

    @When("user clicks on {string}")
    public void user_clicks_on(String module) {
        BasePage.navigateToModule(module);
    }

    @Then("the title should be {string}")
    public void the_title_should_be(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
