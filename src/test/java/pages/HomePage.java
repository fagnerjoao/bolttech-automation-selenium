package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import runner.Driver;
import support.Utils;

public class HomePage extends Driver {

    private WebDriver driver;

    public HomePage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[contains(@class, 'fa-home')]")
    private WebElement btnHome;

    @FindBy(xpath = "//a[contains(text(),' Logout')]")
    private WebElement btnLogout;

    @FindBy(xpath = "//a[@href='/products']/i[contains(@class, 'material-icons') and contains(@class, 'card_travel')]")
    private WebElement btnProducts;

    @FindBy(xpath = "//div[@class='brands_products']")
    private WebElement brandsProductsDiv;

    @FindBy(xpath = "//a[@href='/products']/i[contains(@class, 'material-icons') and contains(@class, 'card_travel')]")
    private WebElement brand;

    @FindBy(xpath = "//a[contains(text(),'Polo')]")
    private WebElement linkPolo;

    @FindBy(xpath = "//a[contains(@class,'add-to-cart') and contains(text(),'Add to cart')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//p[@class='text-center']")
    private WebElement popUpCartMsn;

    @FindBy(xpath = "//button[contains(@class,'btn-success') and text()='Continue Shopping']")
    private WebElement btnContinueShopping;

    @FindBy(xpath = "//a[contains(@href, '/view_cart')]/u")
    private WebElement linkViewCart;

    public void clickBtnHome() {

        btnHome.click();
        btnProducts.click();
    }


    public void verifyHomePageIsLoad() {
       Utils.waitElementPresent(By.xpath("//a[contains(text(),' Logout')]"));
    }

    public void selectBrand(String brandName) {
        driver.findElement(By.xpath("//a[contains(@href, '/brand_products/"+ brandName+"')]"));

    }
    public void selectproduct(String productName) {
        Utils.waitElementPresent(By.xpath("//p[contains(text(),'"+ productName +"')]"));
        driver.findElement(By.xpath("//p[contains(text(),'"+ productName +"')]"));
    }

    public void addProductToCart(String brandName, String productName) {
        Utils.scrollToElement(brandsProductsDiv);
        selectBrand(brandName);
        selectproduct(productName);
        addToCartButton.click();
    }

    public void verifyCartMsn() {
        Utils.waitElementPresent(By.xpath("//p[@class='text-center']"));

        String msn = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", popUpCartMsn);
        Assert.assertEquals("Your product has been added to cart.", msn);

        String btn = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", btnContinueShopping);
        Assert.assertEquals("Continue Shopping", btn);

    }

    public void accessViewCart() {
        Utils.waitElementPresent(By.xpath("//a[contains(@href, '/view_cart')]/u"));
        linkViewCart.click();
    }

}
