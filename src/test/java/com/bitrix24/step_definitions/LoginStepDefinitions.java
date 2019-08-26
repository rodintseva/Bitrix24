package com.bitrix24.step_definitions;

import com.bitrix24.utils.ConfigurationReader;
import com.bitrix24.utils.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {
    Pages pages = new Pages();
     @Given("User is on landing page")
    public void user_is_on_landing_page() {
        // Write code here that turns the phrase above into concrete actions
        pages.loginPage().goToLandingPage();

    }

    @When("user logs in as a help desk")
    public void user_logs_in_as_a_help_desk() {
    String username= ConfigurationReader.getProperty("helpdesk35username");
    String password=ConfigurationReader.getProperty("helpdesk35password");
    pages.loginPage().login(username,password);

  }

    @Then("{string} page name is displayed")
    public void page_name_is_displayed(String expected) {

        Assert.assertEquals(expected, pages.messagePage().getPageTitle());
    }


}
