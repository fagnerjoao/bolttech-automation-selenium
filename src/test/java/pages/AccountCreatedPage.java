package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import runner.Driver;
import support.Utils;

public class AccountCreatedPage extends Driver {

    private WebDriver driver;

    public AccountCreatedPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@data-qa='account-created']")
    private WebElement successTitle;

    @FindBy(xpath = "//p[contains(text(),'Congratulations! Your new account has been successfully created!')]")
    private WebElement successTxt;

    public void verufySuccessSignup() {
        Utils.waitElementPresent(By.xpath("//h2[@data-qa='account-created']"));
        String title = successTitle.getText();
        Assert.assertEquals("ACCOUNT CREATED!", title);

        String msn = successTxt.getText();
        Assert.assertEquals("Congratulations! Your new account has been successfully created!", msn);
    }

}
