package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.CSVReaderUtil;

import java.util.List;

public class OrderTest extends BaseTest {

    @Test
    public void completeOrderFlow() throws Exception {

        List<String> products =
                CSVReaderUtil.getProducts("src/test/resources/productdata.csv");

        String confirmation = new LoginPage()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin()
                .addProducts(products)
                .goToCart()
                .checkout()
                .enterDetails("John","Doe","12345")
                .finishOrder()
                .getConfirmation();

        Assert.assertEquals(confirmation,"Thank you for your order!");
    }
}