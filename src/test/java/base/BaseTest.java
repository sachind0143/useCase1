package base;

import org.testng.annotations.*;
import org.testng.annotations.Optional;
import utils.ConfigReader;

public class BaseTest {

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {

        String url = ConfigReader.get("qaUrl");

        DriverManager.setDriver(DriverFactory.createDriver(browser));
        DriverManager.getDriver().get(url);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}