package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.GooglePage;
import utilities.ConfigReader;
import utilities.Driver;

public class GoogleStepDefs {

    GooglePage googlePage = new GooglePage();
    @Given("user is on the google page")
    public void user_is_on_the_google_page() {
//WRITE YOUR CODE IN HERE FOR THIS STEP
        Driver.getDriver().get(ConfigReader.getProperty("google_url"));
        try{
            googlePage.popUpOkButton.click();
        }catch (Exception e){
//            e.printStackTrace();
        }

    }
    @When("user search for iPhone on google")
    public void user_search_for_i_phone_on_google() {
//        Driver.getDriver().findElement(By.name("q")).sendKeys("iPhone"+ Keys.ENTER);
        googlePage.searchBox.sendKeys("iPhone"+Keys.ENTER);
    }
    @Then("verify the page title contains iPhone")
    public void verify_the_page_title_contains_i_phone() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("iPhone"));
    }
    @Then("close the application")
    public void close_the_application() {
        Driver.closeDriver();
    }
    @When("user search for TeaPot on google")
    public void user_search_for_tea_pot_on_google() {
        googlePage.searchBox.sendKeys("TeaPot"+Keys.ENTER);
    }
    @Then("verify the page title contains TeaPot")
    public void verify_the_page_title_contains_tea_pot() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("TeaPot"));
    }

    @When("user search for Flower on google")
    public void user_search_for_flower_on_google() {
        googlePage.searchBox.sendKeys("Flower"+Keys.ENTER);
    }
    @Then("verify the page title contains Flower")
    public void verify_the_page_title_contains_flower() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Flower"));
    }

    @When("user search for BMW on google")
    public void user_search_for_bmw_on_google() {
        googlePage.searchBox.sendKeys("BMW"+Keys.ENTER);
    }
    @Then("verify the page title contains BMW")
    public void verify_the_page_title_contains_bmw() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("BMW"));
    }


}
