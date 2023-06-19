package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import runner.Driver;
import support.Utils;

public class SignupPage extends Driver {
    private WebDriver driver;

    public SignupPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@title='Advertisement']")
    private WebElement advertisement;

    @FindBy(xpath = "//b[contains(text(),'Enter Account Information')]")
    private WebElement signupTitle;

    @FindBy(id = "id_gender1")
    private WebElement radioTitleM;

    @FindBy(id = "id_gender2")
    private WebElement radioTitleF;

    @FindBy(id = "name")
    private WebElement inputName;

    @FindBy(id = "email")
    private WebElement inputEmail;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(id = "days")
    private WebElement selectDays;

    @FindBy(id = "months")
    private WebElement selectMonths;

    @FindBy(id = "years")
    private WebElement selectYears;

    @FindBy(id = "newsletter")
    private WebElement checkboxNewsletter;

    @FindBy(id = "optin")
    private WebElement checkboxOptin;

    @FindBy(id = "first_name")
    private WebElement inputFirst_name;

    @FindBy(id = "last_name")
    private WebElement inputLast_name;

    @FindBy(id = "company")
    private WebElement inputCompany;

    @FindBy(id = "address1")
    private WebElement inputAddress1;

    @FindBy(id = "address2")
    private WebElement inputAddress2;

    @FindBy(id = "country")
    private WebElement selectCountry;

    @FindBy(id = "state")
    private WebElement inputState;

    @FindBy(id = "city")
    private WebElement inputCity;

    @FindBy(id = "zipcode")
    private WebElement inputZipcode;

    @FindBy(id = "mobile_number")
    private WebElement inputMobileNumber;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement btnCreateAccount;

    @FindBy(xpath = "//*[contains(text(),'Account Created!')]")
    private WebElement msnSuccess;

    @FindBy(xpath = "//button[@data-qa='continue-button']")
    private WebElement btnContinue;




    public void verufySignupFomrTitle() {
        Utils.waitElementPresent(By.xpath("//b[contains(text(),'Enter Account Information')]"));
        String result = signupTitle.getText();
        Assert.assertEquals("ENTER ACCOUNT INFORMATION", result);
    }

    public void fillForm(String firstName, String lastName, String password, String dateOfBirth, String address, String country, String state, String city, String zipCode, String mobileNumber) {
        Utils.waitElementPresent(By.xpath("//div[@title='Advertisement']"));

        inputFirst_name.sendKeys(firstName);
        inputLast_name.sendKeys(lastName);
        inputPassword.sendKeys(password);
        String[] dobParts = dateOfBirth.split(" "); // dateOfBirth is in the format "3 August 1990"
        selectDays.sendKeys(dobParts[0].replaceAll("\\D+", ""));
        selectMonths.sendKeys(dobParts[1]);
        selectYears.sendKeys(dobParts[2]);
        inputAddress1.sendKeys(address);
        selectCountry.sendKeys(country);
        inputState.sendKeys(state);
        inputCity.sendKeys(city);
        inputZipcode.sendKeys(zipCode);
        inputMobileNumber.sendKeys(mobileNumber);
        Utils.scrollToElement(btnCreateAccount);
        btnCreateAccount.click();
    }



}
