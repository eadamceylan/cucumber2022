package stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.DefaultPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtil;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelStepDefs {

    HomePage homePage;
    LoginPage loginPage;
    DefaultPage defaultPage;
    ExcelUtil excelUtil;
    //    We will store excel data in this list
    List<Map<String, String>> testData;
    public void login(){
//        going to the home page url
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
//        initiating pages
        homePage = new HomePage();
        loginPage = new LoginPage();
        defaultPage = new DefaultPage();

        try{
//            THIS RUNS ONLY ON  THE FIRST LOGIN
//            clinking on the homelogin button
//            homepage login is only visible at the first login
//            We should put this in try catch block, to catch the exception after 1st login
//            If I do not use this, then I will get NoSuchElementException after the first login
            homePage.homeLoginButton.click();
        }catch (Exception e){
//            e.printStackTrace();
        }

        try{
//            THIS IS GOING TO RUN AFTER THE FIRST LOGIN
//            After the 1st login, I need to log out
//            In the first login logout is not then
//            So I need to use try catch to catch the exception in the 1st login
//            If I do not use this, then I will get NoSuchElementException after the first login
            defaultPage.userID.click();
            defaultPage.logOut.click();
            defaultPage.OK.click();
            homePage.homeLoginButton.click();
        }catch (Exception e){

        }
    }


    @Given("user login with excel as {string}")
    public void user_login_with_excel_as(String string) throws IOException {

//        path of the excel sheet
        String path = "./src/test/resources/testdata/mysmoketestdata.xlsx";
//        customer data sheet
        String credentialsPath=string+"_info";
//        Use ExcelUtil to
        excelUtil= new ExcelUtil(path,credentialsPath);
//        getting the data and storing in the test-data variable
        testData=excelUtil.getDataList();
//        System.out.println(testData);
        for (Map<String, String> eachData:testData){
//            System.out.println(eachData);
            login();
            ReusableMethods.waitFor(2);
            loginPage.username.sendKeys(eachData.get("username"));
            ReusableMethods.waitFor(2);
            loginPage.password.sendKeys(eachData.get("password").substring(0,5));
            ReusableMethods.waitFor(2);
            loginPage.loginButton.click();
            ReusableMethods.waitFor(2);
//            Assertion
            Assert.assertTrue(defaultPage.userID.isDisplayed());
//            Take a screenshot
            ReusableMethods.getScreenshot("ManagerLoginTest");

        }
    }
}
