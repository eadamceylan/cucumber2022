package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
        "html:target/default-cucumber-reports.html",
        "json:target/json-reports/cucumber.json",
        "junit:target/xml-report/cucumber.xml"
        },

        features = "./src/test/resources/features",//path od features folder
        glue = {"stepdefinitions","hooks"},//path of the step definitions folder
        tags = "@customer_login",
        dryRun = false
)
public class Runner {
}
/*
Runner class is used to run the feature files
@RunWith : makes this class runnable
@CucumberOptions :
    1. features : path of the features folder
    2. glue : path of the step definitions folder
 */