package pages;

import base.DriverManager;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class ProductsPage {

    WebDriver driver;

    @FindBy(className="inventory_item_name")
    java.util.List<WebElement> products;

    @FindBy(className="shopping_cart_link")
    WebElement cart;

    public ProductsPage(){
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    public ProductsPage addProducts(List<String> productList){

        for(String productName : productList){

            for(WebElement product : products){

                if(product.getText().equalsIgnoreCase(productName)){

                    WebElement addBtn = product.findElement(
                        By.xpath("./ancestor::div[@class='inventory_item']//button")
                    );

                    addBtn.click();
                    break;
                }
            }
        }

        return this;
    }

    public CartPage goToCart(){
        cart.click();
        return new CartPage();
    }
}