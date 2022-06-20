package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PaymentPage {
    public PaymentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='modal-title h4']")
    public WebElement completeReservation;

    @FindBy(xpath = "//input[@name='cardNo']")
    public WebElement cardNumber;

    @FindBy(xpath = "//input[@name='nameOnCard']")
    public WebElement cardName;

    @FindBy(xpath = "//input[@name='expireDate']")
    public WebElement expireDate;

    @FindBy(xpath = "//input[@name='cvc']")
    public WebElement CVC;

    @FindBy(xpath = "//input[@name='contract']")
    public WebElement contract;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement completeReservation2;
}
