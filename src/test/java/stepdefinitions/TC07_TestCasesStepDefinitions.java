package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TC07_TestCasesPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC07_TestCasesStepDefinitions extends ReusableMethods {

    TC07_TestCasesPage testCasesPage = new TC07_TestCasesPage();

    @Given("user launches the browser")
    public void user_launches_the_browser() {
        Driver.getDriver();
    }


    @When("user navigates to URL")
    public void user_navigates_to_url() {
        Driver.getDriver().get(ConfigReader.getProperty("automation_exercise_url"));
    }


    @Then("user verifies that home page is visible successfully")
    public void user_verifies_that_home_page_is_visible_successfully() {
        Assert.assertEquals("https://automationexercise.com/",Driver.getDriver().getCurrentUrl());
    }

    @And("user clicks on Test Cases button")
    public void userClicksOnTestCasesButton() {
        testCasesPage.testCasesLink.click();
    }

    @Then("user is navigated to test cases page successfully")
    public void user_is_navigated_to_test_cases_page_successfully() {
        Assert.assertTrue(testCasesPage.testCasesText.isDisplayed()); //1.way
//        Assert.assertEquals("TEST CASES",testCasesPage.testCasesText.getText()); //2.way
    }

    @Then("user closes the browser")
    public void user_closes_the_browser() {
        Driver.closeDriver();
    }

    /*****************************************************************************************************/

    @Then("user scrolls to bottom of the page")
    public void user_scrolls_to_bottom_of_the_page() {
       scrollIntoViewByJS(testCasesPage.recommendedItems);
    }
    @Then("user verifies RECOMMENDED ITEMS are visible")
    public void user_verifies_recommended_items_are_visible() {
        testCasesPage.recommendedItems.isDisplayed();
    }
    @Then("user clicks on Add To Cart button on Recommended product")
    public void user_clicks_on_add_to_cart_button_on_recommended_product() throws InterruptedException {
        testCasesPage.addToCartButtonOnRecommended.click();
        Thread.sleep(2000);
    }
    @Then("user clicks on View Cart button")
    public void user_clicks_on_view_cart_button() throws InterruptedException {
        testCasesPage.viewCartButton.click();
        Thread.sleep(2000);

    }
    @Then("user verifies that product is displayed in the cart page")
    public void user_verifies_that_product_is_displayed_in_the_cart_page() throws InterruptedException {
        testCasesPage.productInsideOfCart.isDisplayed();
        Thread.sleep(2000);

    }
}