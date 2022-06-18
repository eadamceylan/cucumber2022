package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import pages.DefaultPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class LoginStepDefs {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
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
        loginPage.username.sendKeys(string);
    }

    @Given("user sends password {string}")
    public void user_sends_password(String string) {
        loginPage.password.sendKeys(string);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.loginButton.click();
    }

    @Given("user enters admin_username and admin_password")
    public void user_enters_admin_username_and_admin_password(DataTable credentials) {
//        1.Way: We can store data as a List
//      List<String> adminCredentials =  credentials.row(1);
//      loginPage.username.sendKeys(adminCredentials.get(0)); //first element of adminCredentials List
//       loginPage.password.sendKeys(adminCredentials.get(1));
//  adminCredentials => [ admin@bluerentalcars.com, 12345 ]


//        2.way : We can store data as List<Map<String,String>>
//        {admin_id=admin@bluerentalcars.com, admin_pass=12345}

        List<Map<String,String>> adminCredentials = credentials.asMaps(String.class,String.class);

        for(Map<String,String> eachCredential : adminCredentials){
            loginPage.username.sendKeys(eachCredential.get("admin_id")); // value of asmid id
            loginPage.password.sendKeys(eachCredential.get("admin_pass"));
        }

//      1.way is easier and more understandable, you can use first way

    }



    @Then("verify the login is successful")
    public void verify_the_login_is_successful() {
        Assert.assertTrue(defaultPage.userID.isDisplayed());

    }

    @When("test case fails")
    public void test_case_fails() {
        Assert.assertTrue(false);
    }

}