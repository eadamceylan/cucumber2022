package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        //

        plugin = {
                "pretty",
                "html:target/default_cucumber_report.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failedRerun.txt"
//                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        },
        features = "./src/test/resources/features",//path od features folder
        glue = {"stepdefinitions"},//path of the step definitions folder
        tags = "@smoke_test",
        dryRun = false
)
public class SmokeTestRunner {


}
