package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.GooglePage;
import utilities.Driver;

public class ParameterizationStepDefs {

    GooglePage googlePage = new GooglePage();

    @When("user search for {string} on google")
    public void user_search_for_on_google(String string) {
        googlePage.searchBox.sendKeys(string+ Keys.ENTER);

    }
    @Then("verify the page title contains {string}")
    public void verify_the_page_title_contains(String string) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));

    }
}
