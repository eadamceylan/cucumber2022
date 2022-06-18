package hooks;

import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {

    @Before
    public void setUp(){
        System.out.println("This is before method");
    }

    @After
    public void tearDown(Scenario scenario){
        System.out.println("This is after method");

    // It runs after every scenario

    final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
    scenario.attach(screenshot,"image/png","screenshots");
    }

}
