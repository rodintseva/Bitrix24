package com.bitrix24.step_definitions;

import com.bitrix24.utils.Pages;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class NavigationStepDefinitionsEkaterina {
    Pages page =new Pages();

    @When("user clicks on specific {string}")
    public void userClicksOnSpecific(String module) {

        page.taskPage().navigateToModule(module);
    }

    @Then("the title on the page should be equal to module name {string}")
    public void theTitleOnThePageShouldBeEqualToModuleName(String module) {
        Assert.assertEquals(module, page.taskPage().returnPageTitle(module));
    }



}

