package pages;

import base.DriverManager;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(id="checkout")
    WebElement checkout;

    public CartPage(){
    	 driver = DriverManager.getDriver();

         // IMPORTANT: initialize wait
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));

         PageFactory.initElements(driver, this);
    }

    public CheckoutPage checkout(){
    	wait.until(ExpectedConditions.elementToBeClickable(checkout));
        checkout.click();
        return new CheckoutPage();
    }
}