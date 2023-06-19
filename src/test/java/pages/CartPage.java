package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import runner.Driver;
import support.Utils;

public class CartPage extends Driver {

    private WebDriver driver;

    public CartPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[contains(text(),'\"+ productName +\"')]")
    private WebElement linkProducts;

    @FindBy(xpath = "//a[contains(text(),'Proceed To Checkout')]")
    private WebElement btnProceedToCheckout;


    public void verifyProductInCart(String productName) {
        Utils.waitElementPresent(By.xpath("//a[contains(text(),'Proceed To Checkout')]"));
        driver.findElement(By.xpath("//a[contains(text(),'"+ productName +"')]"));

    }

}
