package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GridStepDefs {
    WebDriver driver;
    @Given("user is on the application_URL with chrome")
    public void user_is_on_the_application_url_with_chrome() throws MalformedURLException {
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
        driver= new RemoteWebDriver(new URL("http://192.168.0.14:4444"),new ChromeOptions());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.bluerentalcars.com/");
    }
    @Given("verify the title of the page is {string}")
    public void verify_the_title_of_the_page_is(String string) {
        String actualTitle = driver.getTitle();
        String expectedTitle = string;
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    @Then("close the remote driver")
    public void close_the_remote_driver() {
        driver.quit();
    }

    @Given("user is on the application_URL with firefox")
    public void user_is_on_the_application_url_with_firefox() throws MalformedURLException {
        driver= new RemoteWebDriver(new URL("http://192.168.0.14:4444"),new FirefoxOptions());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.bluerentalcars.com/");
    }


}
