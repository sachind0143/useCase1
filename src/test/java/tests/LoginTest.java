package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import utils.CSVReaderUtil;

public class LoginTest extends BaseTest {

    @DataProvider
    public Object[][] loginData() throws Exception {
        return CSVReaderUtil.getData("src/test/resources/testdata.csv");
    }

    @Test(dataProvider="loginData")
    public void loginTest(String username,String password,String expected){

        LoginPage login = new LoginPage();

        login.enterUsername(username)
             .enterPassword(password)
             .clickLogin();

        if(expected.equals("success")){
            Assert.assertTrue(
                    base.DriverManager.getDriver()
                            .getCurrentUrl().contains("inventory")
            );
        }else{
            Assert.assertTrue(login.getError().contains("Epic sadface"));
        }
    }
}