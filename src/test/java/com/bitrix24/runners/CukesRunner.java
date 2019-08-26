package com.bitrix24.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "html:target/default-cucumber-reports"
        },
//         tags = {"@AttachFile"},
        features = {"src/test/resources/features/Aydin_Navigation.feature"
        },
        glue = {"com/bitrix24/step_definitions"},
        dryRun = false
    )

    public class CukesRunner {
    }
