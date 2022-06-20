package stepdefinitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.DefaultPage;
import pages.PaymentPage;
import utilities.Driver;

public class ReserveCarStepDefs {
    DefaultPage defaultPage = new DefaultPage();
    PaymentPage paymentPage = new PaymentPage();

    @When("user selects a {string}")
    public void user_selects_a(String car) {
        Select select = new Select(defaultPage.select_car);
        select.selectByVisibleText(car);
    }


    @When("user enters pick up place {string}")
    public void user_enters_pick_up_place(String place) {
        Driver.waitAndSendText(defaultPage.pick_place,place);
    }

    @When("user enters drop off place {string}")
    public void user_enters_drop_off_place(String string) {
        Driver.waitAndSendText(defaultPage.drop_place,string);
    }

    @When("user enters pick up date {string}")
    public void user_enters_pick_up_date(String string) {
        Driver.waitAndSendText(defaultPage.pick_date,string);
    }

    @When("user enters pick up time {string}")
    public void user_enters_pick_up_time(String string) {
//        Driver.waitAndSendText(defaultPage.pick_time,string);
//   both of them are OK
        defaultPage.pick_time.sendKeys(string);
    }

    @When("user enters drop off date {string}")
    public void user_enters_drop_off_date(String string) {
        Driver.waitAndSendText(defaultPage.drop_date,string);
    }

    @When("user enters drop off time {string}")
    public void user_enters_drop_off_time(String string) {
        Driver.waitAndSendText(defaultPage.drop_time,string);
    }


    @Then("user clicks on continue reservation")
    public void user_clicks_on_continue_reservation() {
//       defaultPage.continueReservationButton.click();
        Driver.waitAndClick(defaultPage.continueReservationButton);
    }



    @Then("verify complete reservation screen pop up")
    public void verify_complete_reservation_screen_pop_up() {
        Assert.assertTrue(paymentPage.completeReservation.isDisplayed());
    }


    @Then("user enters card number {string}")
    public void user_enters_card_number(String string) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(paymentPage.cardNumber).click().sendKeys(Keys.HOME).sendKeys(string).build().perform();
    }


    @Then("user enters {string} on the card")
    public void user_enters_on_the_card(String string) {
        Driver.waitAndSendText(paymentPage.cardName,string);
    }

    //                  expire_date  CVC
    @Then("user enters {string} and {string}")
    public void user_enters_and(String expire_date, String CVC) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(paymentPage.expireDate).click().sendKeys(Keys.HOME).sendKeys(expire_date).build().perform();
        actions.moveToElement(paymentPage.CVC).click().sendKeys(Keys.HOME).sendKeys(CVC).build().perform();
    }


    @Then("user checks the agreement")
    public void user_checks_the_agreement() {
        Driver.waitAndClick(paymentPage.contract);
    }

    @Then("user clicks complete reservation")
    public void user_clicks_complete_reservation() {
        Driver.waitAndClick(paymentPage.completeReservation2);
    }

    @Then("verify Reservation created successfully pop up")
    public void verify_reservation_created_successfully_pop_up() {

    }


    @Then("user closes application")
    public void userClosesApplication() {
        Driver.closeDriver();
    }
}