package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BluerentalcarsContinueReservationPage {

    public BluerentalcarsContinueReservationPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name='cardNo']")
    public WebElement creditCardBox;

    @FindBy(xpath = "//input[@name='nameOnCard']")
    public WebElement nameOnCardBox;

    @FindBy(xpath = "//input[@name='expireDate']")
    public WebElement expireDateBox;

    @FindBy(xpath = "//input[@name='cvc']")
    public WebElement cvcBox;

    @FindBy(xpath = "//h5[contains(text(),'Payment')]")
    public WebElement paymentPageH5;

    @FindBy(xpath = "//input[@name='contract']")
    public WebElement aggrementCheckBox;

    @FindBy(xpath = "(//div[@class='modal-footer']/button)[2]")
    public WebElement completeReservationBtn;

    @FindBy(xpath = "(//div[@class='modal-footer']/button)[1]")
    public WebElement closeReservationBtn;

    @FindBy(xpath ="//*[.='Reservation created successfully']")
    public WebElement reservationSuccessfulMsgAlert;
}