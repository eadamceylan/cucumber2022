package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;
public class BluerentalcarsReservationDetailsPage {

    public BluerentalcarsReservationDetailsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='header-content']/h1")
    public WebElement reservationDetailH1;

    @FindBy(xpath = "//button[contains(text(),'Car Details')]")
    public WebElement carDetailsAccordionBtn;

    @FindBy(xpath = "//button[contains(text(),'Reservation Details')]")
    public WebElement reservationDetailsAccordionBtn;

    @FindBy(xpath = "(//div[@class='accordion-body'])[2]/table/tbody/tr/td[1]")
    public List<WebElement> carDetailsFirstColumn;

    @FindBy(xpath = "(//div[@class='accordion-body'])[2]/table/tbody/tr/td[2]")
    public List<WebElement> carDetailsSecondColumn;

    @FindBy(xpath = "//button[contains(text(),'Back to reservations')]")
    public WebElement backToReservationsBtn;
}