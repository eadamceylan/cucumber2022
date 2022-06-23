package stepdefinitions;

import io.cucumber.java.en.*;
import mocktestdata.MockData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BluerentalcarsHomePage;
import pages.BluerentalcarsReservationDetailsPage;
import pages.BluerentalcarsReservationsPage;
import utilities.Driver;
import utilities.ReusableMethods;
import java.util.List;
public class US08ReserveCarStepDefs {
    private BluerentalcarsHomePage homePage = new BluerentalcarsHomePage();
    private BluerentalcarsReservationsPage reservationsPage;
    private BluerentalcarsReservationDetailsPage reservationDetailsPage;
    private WebElement lastResTr;
    @When("navigated to Reservations screen")
    public void navigated_to_reservations_screen() {
        Driver.wait(5);
        ReusableMethods.hover(homePage.dropdownLoggedUserBtn);
        homePage.dropdownLoggedUserBtn.click();
        Driver.waitForVisibility(homePage.reservationsLink,3);
        homePage.reservationsLink.click();
        reservationsPage = new BluerentalcarsReservationsPage();
    }
    @When("verify the last reservation is created")
    public void verify_the_last_reservation_is_created() {
        List<WebElement> trs = reservationsPage.trsOfReservationTable;
        Assert.assertTrue(trs.size()>0);

        String carName = reservationsPage.lastRowCarName.getText();
        String pickup = reservationsPage.lastRowPickup.getText();
        String dropoff = reservationsPage.lastRowDropoff.getText();

        Assert.assertEquals(MockData.getCar(),carName);
        Assert.assertTrue(pickup.contains(MockData.getPick_up_place()));
        Assert.assertTrue(dropoff.contains(MockData.getDrop_off_place()));

    }
    @When("you click on the last reservation")
    public void you_click_on_the_last_reservation() {
        Driver.executeJScommand(reservationsPage.lastRowOfReservationTable,
                "arguments[0].scrollIntoView(true);");
        Actions actions= new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Driver.waitForVisibility(reservationsPage.lastRowOfReservationTable,3);
        reservationsPage.lastRowOfReservationTable.click();
        reservationDetailsPage = new BluerentalcarsReservationDetailsPage();
    }
    @Then("verify that reservation detail page is displayed")
    public void verify_that_reservation_detail_page_is_displayed() {
        Assert.assertTrue(reservationDetailsPage.reservationDetailH1.isDisplayed());
    }
    @Then("verify the table has the following fields:Model, Doors, Seats, Luggage, Transmission, Air Conditioning, Fuel Type, Age")
    public void verify_the_table_has_the_following_fields_model_doors_seats_luggage_transmission_air_conditioning_fuel_type_age() {
        Driver.executeJScommand(reservationDetailsPage.carDetailsAccordionBtn,
                "arguments[0].scrollIntoView(true);");
        Actions actions= new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Driver.waitForClickablility(reservationDetailsPage.carDetailsAccordionBtn,3);
        Driver.clickWithJS(reservationDetailsPage.carDetailsAccordionBtn);
        //reservationDetailsPage.carDetailsAccordionBtn.click();

        List<WebElement> carDetailsFirstCol = reservationDetailsPage.carDetailsFirstColumn;
        List<WebElement> carDetailsSecondCol = reservationDetailsPage.carDetailsSecondColumn;
        Assert.assertEquals(carDetailsFirstCol.get(0).getText(),"Model");
        Assert.assertNotEquals(carDetailsSecondCol.get(0).getText(),"");
        Assert.assertEquals(carDetailsFirstCol.get(1).getText(),"Doors");
        Assert.assertNotEquals(carDetailsSecondCol.get(1).getText(),"");
        Assert.assertEquals(carDetailsFirstCol.get(2).getText(),"Seats");
        Assert.assertNotEquals(carDetailsSecondCol.get(2).getText(),"");
        Assert.assertEquals(carDetailsFirstCol.get(3).getText(),"Luggage");
        Assert.assertNotEquals(carDetailsSecondCol.get(3).getText(),"");
        Assert.assertEquals(carDetailsFirstCol.get(4).getText(),"Transmission");
        Assert.assertNotEquals(carDetailsSecondCol.get(4).getText(),"");
        Assert.assertEquals(carDetailsFirstCol.get(5).getText(),"Air Conditioning");
        Assert.assertEquals(carDetailsSecondCol.get(5).getText(),"");
        Assert.assertEquals(carDetailsFirstCol.get(6).getText(),"Fuel Type");
        Assert.assertNotEquals(carDetailsSecondCol.get(6).getText(),"");
        Assert.assertEquals(carDetailsFirstCol.get(7).getText(),"Age");
        Assert.assertNotEquals(carDetailsSecondCol.get(7).getText(),"");
    }
    @Then("click on back to reservations")
    public void click_on_back_to_reservations() {
        Driver.executeJScommand(reservationDetailsPage.backToReservationsBtn,
                "arguments[0].scrollIntoView(true);");
        Driver.clickWithJS(reservationDetailsPage.backToReservationsBtn);
        //reservationDetailsPage.backToReservationsBtn.click();
    }
    @Then("verify Reservations page is displayed")
    public void verify_reservations_page_is_displayed() {
        Assert.assertTrue(reservationsPage.reservationsH1.isDisplayed());
    }
    @Then("click on Home link")
    public void click_on_home_link() {
        reservationsPage.homeLink.click();
    }
    @Then("verify the home page is displayed")
    public void verify_the_home_page_is_displayed() {
        Assert.assertTrue(homePage.carSelectionDropDown.isDisplayed());

    }
}