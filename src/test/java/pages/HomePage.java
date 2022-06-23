package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(partialLinkText = "Login")
    public WebElement homeLoginButton;

    @FindBy(xpath = "//*[@id='dropdown-basic-button']")
    public WebElement userNameDropDown;

    @FindBy(xpath = "(//*[@class='dropdown-item'])[1]")
    public WebElement homePageReservationsDropDown;




}
