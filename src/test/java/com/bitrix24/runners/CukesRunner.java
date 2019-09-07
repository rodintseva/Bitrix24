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
            features = {"src/test/resources/features/login/Login",
            } ,
                       /*
                        * feature contains scenarios
                        * every scenario is like a test
                        * where is the implementation for features
                        */
            glue = {"com/bitrix24/step_definitions"},
            dryRun = true,
            tags ="@wip"
    )
    public class CukesRunner {
    }
