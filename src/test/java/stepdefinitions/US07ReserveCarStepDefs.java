package stepdefinitions;

import io.cucumber.java.en.*;
import mocktestdata.MockData;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.BluerentalcarsContinueReservationPage;
import pages.DefaultPage;
import pages.BluerentalcarsHomePage;
import utilities.Driver;

public class US07ReserveCarStepDefs {

    private BluerentalcarsHomePage homePage = new BluerentalcarsHomePage();
    private BluerentalcarsContinueReservationPage continueReservationPage;

    @Then("user select a car {string}")
    public void user_select_a_car(String carName) {
        Select carSelect = new Select(homePage.carSelectionDropDown);
        //carSelect.selectByVisibleText(carName);
        carSelect.selectByVisibleText(MockData.getCar());
    }

    @Then("user enters pickup place {string}")
    public void user_enters_pickup_place(String pickupPlace) {

        // homePage.pickUpLocation.sendKeys(pickupPlace);
        homePage.pickUpLocation.sendKeys(MockData.getPick_up_place());
    }

    @Then("user enters dropoff place {string}")
    public void user_enters_dropoff_place(String dropoffPlace) {

        homePage.dropOfLocation.sendKeys(MockData.getDrop_off_place());

    }

    @Then("user enters pickup date {string}")
    public void user_enters_pickup_date(String pickupDate) {
        String dt = MockData.getPickup_date();
        homePage.pickUpDate.sendKeys(dt);
    }

    @Then("user enters pickup time {string}")
    public void user_enters_pickup_time(String pickupTime) {
        homePage.pickUpTime.sendKeys(MockData.getPickup_time());
    }

    @Then("user enters dropoff date {string}")
    public void user_enters_dropoff_date(String dropoffDate) {

        homePage.dropOffDate.sendKeys(MockData.getDropoff_date());
    }

    @Then("user enters dropoff time {string}")
    public void user_enters_dropoff_time(String dropoffTime) {

        //homePage.dropOffTime.sendKeys(dropoffTime);
        homePage.dropOffTime.sendKeys(MockData.getDropoff_time());
    }

    @Then("click continue reservation")
    public void click_continue_reservation() {
        homePage.continueReservationBtn.click();
        continueReservationPage = new BluerentalcarsContinueReservationPage();
    }

    @Then("verify complete reservation screen pops up")
    public void verify_complete_reservation_screen_pops_up() {
        Assert.assertTrue(continueReservationPage.paymentPageH5.isDisplayed());
    }

    @Then("enter credit card {string}")
    public void enter_credit_card(String creditCardNo) {
        Driver.executeJScommand(continueReservationPage.creditCardBox, "arguments[0].scrollIntoView(true);");
        //creditCardNo = MockData.shuffle(creditCardNo);
        creditCardNo = MockData.getCard_number();
        fillWithKeys(continueReservationPage.creditCardBox, creditCardNo);
    }

    @Then("enter credit card name on card {string}")
    public void enter_credit_card_name(String creditCardName) {
        Driver.executeJScommand(continueReservationPage.nameOnCardBox, "arguments[0].scrollIntoView(true);");
        //Driver.clickWithJS(continueReservationPage.nameOnCardBox);
        //Driver.executeJScommand(continueReservationPage.nameOnCardBox,
        //        "argument[0].value="+creditCardName+";");

        //fillWithKeys(continueReservationPage.nameOnCardBox,creditCardName);
        fillWithKeys(continueReservationPage.nameOnCardBox,MockData.getCard_name());
    }

    @Then("enter expire date {string} and cvc {string}")
    public void enter_and(String expireDate, String cvc) {
        Driver.executeJScommand(continueReservationPage.expireDateBox, "arguments[0].scrollIntoView(true);");
        //fillWithKeys(continueReservationPage.expireDateBox,expireDate);
        fillWithKeys(continueReservationPage.expireDateBox,MockData.getCard_expire_date());
        //fillWithKeys(continueReservationPage.cvcBox, cvc);
        fillWithKeys(continueReservationPage.cvcBox, MockData.getCvc());
    }

    @Then("checks the aggreement")
    public void checks_the_aggreement() {
        continueReservationPage.aggrementCheckBox.click();
    }

    @Then("click complete reservation")
    public void click_complete_reservation() {
        continueReservationPage.completeReservationBtn.click();
    }

    @Then("verify Reservation created successfully pop up")
    public void verify_reservation_created_successfully_pop_up() {
        Driver.waitForVisibility(continueReservationPage.reservationSuccessfulMsgAlert,5) ;
        Assert.assertTrue(continueReservationPage.reservationSuccessfulMsgAlert.isDisplayed());
    }

    private void fillWithKeys(WebElement el, String value) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(el).
                click().
                sendKeys(Keys.HOME).
                sendKeys(value).build().perform();
    }



}