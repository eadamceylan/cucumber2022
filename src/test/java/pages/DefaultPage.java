package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DefaultPage {

    public DefaultPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@id='dropdown-basic-button']")
    public WebElement userID;
    @FindBy(linkText = "Logout")
    public WebElement logOut;
    @FindBy(xpath = "//button[text()='OK']")
    public WebElement OK;

    @FindBy(xpath = "//select[@name='car']")
    public WebElement select_car;

    @FindBy(xpath = "//input[@name='pickUpLocation']")
    public WebElement pick_place;

    @FindBy(xpath = "//input[@name='dropOfLocation']")
    public WebElement drop_place;

    @FindBy(xpath = "//input[@name='pickUpDate']")
    public WebElement pick_date;

    @FindBy(xpath = "//input[@name='pickUpTime']")
    public WebElement pick_time;

    @FindBy(xpath = "//input[@name='dropOffDate']")
    public WebElement drop_date;

    @FindBy(xpath = "//input[@name='dropOffTime']")
    public WebElement drop_time;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement continueReservationButton;
}
