package pages;

import base.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage {

    WebDriver driver;

    @FindBy(id="user-name")
    WebElement username;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="login-button")
    WebElement loginBtn;

    @FindBy(css=".error-message-container")
    WebElement errorMsg;

    public LoginPage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    public LoginPage enterUsername(String user){
        username.clear();
        username.sendKeys(user);
        return this;
    }

    public LoginPage enterPassword(String pass){
        password.clear();
        password.sendKeys(pass);
        return this;
    }

    public ProductsPage clickLogin(){
        loginBtn.click();
        return new ProductsPage();
    }

    public String getError(){
        return errorMsg.getText();
    }
}