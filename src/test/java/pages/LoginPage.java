package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import runner.Driver;
import support.Utils;

public class LoginPage extends Driver {

    private WebDriver driver;

    public LoginPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
    private WebElement btnLoginSingup;

    @FindBy(css = "input[data-qa='login-email']")
    private WebElement inputLogin;

    @FindBy(css = "input[data-qa='login-password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement btnLogin;

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    private WebElement signupTitle;

    @FindBy(css = "input[data-qa='signup-name']")
    private WebElement signupName;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement signupEmail;

    @FindBy(xpath = "//button[text()='Signup']")
    private WebElement btnSignup;




    public void verufySignupTitleField() {
        btnLoginSingup.click();
        Utils.waitElementPresent(By.xpath("//h2[text()='New User Signup!']"));
        String result = signupTitle.getText();
        Assert.assertEquals("New User Signup!", result);
    }

    public void sendNameEmailSignup(String name) {

        signupName.click();
        signupName.sendKeys(name);
        signupEmail.click();
        signupEmail.sendKeys(Utils.getRandomEmail());
        btnSignup.click();
    }

    public void sendLogin(String email, String password) {
        btnLoginSingup.click();
        Utils.waitElementPresent(By.xpath("//h2[text()='New User Signup!']"));
        inputLogin.click();
        inputLogin.sendKeys(email);
        inputPassword.click();
        inputPassword.sendKeys(password);
        btnLogin.click();
    }

}
