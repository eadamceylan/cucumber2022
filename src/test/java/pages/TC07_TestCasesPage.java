package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.*;
import javax.xml.xpath.XPath;

public class TC07_TestCasesPage {


    public TC07_TestCasesPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@href='/test_cases'])[1]")
    public WebElement testCasesLink;
    @FindBy(xpath = "//h2//b")
    public WebElement testCasesText;

    @FindBy(className = "recommended_items")
    public WebElement recommendedItems;

    @FindBy(xpath = "(//a[@class='btn btn-default add-to-cart'])[72]")
    public WebElement addToCartButtonOnRecommended;

    @FindBy(xpath = "//*[text()='View Cart']")
    public WebElement viewCartButton;

    @FindBy(xpath = "//*[@class='product_image']")
    public WebElement productInsideOfCart;







}