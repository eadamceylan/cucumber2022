package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class BluerentalcarsReservationsPage {

    public BluerentalcarsReservationsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//table[@class='table table-striped table-bordered table-hover']")
    public WebElement reservationsTable;

    @FindBy(xpath = "//table[@class='table table-striped table-bordered table-hover']/tbody/tr")
    public List<WebElement> trsOfReservationTable;

    @FindBy(xpath = "//table[@class='table table-striped table-bordered table-hover']/tbody/tr[last()]")
    public WebElement lastRowOfReservationTable;

    @FindBy(xpath = "//table[@class='table table-striped table-bordered table-hover']/tbody/tr[last()]/td[2]")
    public WebElement lastRowCarName;

    @FindBy(xpath = "//table[@class='table table-striped table-bordered table-hover']/tbody/tr[last()]/td[3]")
    public WebElement lastRowPickup;

    @FindBy(xpath = "//table[@class='table table-striped table-bordered table-hover']/tbody/tr[last()]/td[4]")
    public WebElement lastRowDropoff;
    @FindBy(xpath = "//div[@class='header-content']/h1")
    public WebElement reservationsH1;

    @FindBy(partialLinkText = "Home")
    public WebElement homeLink;
}