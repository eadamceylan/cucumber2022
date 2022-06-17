
package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DefaultPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginStepDefs {

    HomePage homePage = new HomePage();
    LoginPage loginPage =new LoginPage();
    DefaultPage defaultPage = new DefaultPage();
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
    }
    @Given("user login dropdown")
    public void user_login_dropdown() {
        homePage.homeLoginButton.click();
    }
    @Given("user sends username {string}")
    public void user_sends_username(String string) {
        loginPage.loginButton.sendKeys(string);
    }
    @Given("user sends password {string}")
    public void user_sends_password(String string) {
        loginPage.password.sendKeys(string);
    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.loginButton.click();
    }
    @Then("verify the login successful")
    public void verify_the_login_successful() {
        Assert.assertTrue(defaultPage.userID.isDisplayed());

    }

}
