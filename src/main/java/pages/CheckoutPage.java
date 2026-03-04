package pages;

import base.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class CheckoutPage {

    WebDriver driver;

    @FindBy(id="first-name")
    WebElement firstName;

    @FindBy(id="last-name")
    WebElement lastName;

    @FindBy(id="postal-code")
    WebElement zip;

    @FindBy(id="continue")
    WebElement cont;

    @FindBy(id="finish")
    WebElement finish;

    @FindBy(className="complete-header")
    WebElement confirmation;

    public CheckoutPage(){
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver,this);
    }

    public CheckoutPage enterDetails(String fn,String ln,String z){
        firstName.sendKeys(fn);
        lastName.sendKeys(ln);
        zip.sendKeys(z);
        return this;
    }

    public CheckoutPage finishOrder(){
        cont.click();
        finish.click();
        return this;
    }

    public String getConfirmation(){
        return confirmation.getText();
    }
}