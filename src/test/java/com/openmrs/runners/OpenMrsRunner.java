package com.openmrs.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", //but if we go with ui as well, it good, but most recommended
        //just general location for features
        glue = "com/openmrs/stepdefinitions",
        dryRun = false,
        tags = "@smoke",
        snippets = CucumberOptions.SnippetType.CAMELCASE, //you are not gonna get UnderScore anymore
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt",
        "json:target/cucumber-reports/cucumber.json"}
        //maven will be written the json files


)
//it means execute
public class OpenMrsRunner {
}
